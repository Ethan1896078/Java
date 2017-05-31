package pers.ethan.demo;


import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleRestApplication.class)
@WebIntegrationTest
public class  RestAppTest {
    public interface TestService {
        @RequestLine("POST /customer/addObj/")
        @Headers({"Content-Type: application/json","Accept: application/json"})
        Customer addCustomer(Customer customer);

        @RequestLine("POST /customer/add/")
        @Body("id={id}&name={name}")
        Response addCustomer(@Param("id") Long id, @Param("name") String name);

        @RequestLine("PUT /customer/update/{id}/{name}")
        Response updateCustomer(@Param("id") Long id, @Param("name") String name);

        @RequestLine("GET /customer/id/{id}")
        String getCustomerName(@Param("id") Long id);

        @RequestLine("DELETE /customer/delete/{id}")
        Response deleteCustomer(@Param("id") Long id);
    }

    String baseURL = "http://127.0.0.1:8080/services";

    TestService textService = Feign.builder()
            .options(new Request.Options(1000, 3500))
            .retryer(new Retryer.Default(5000, 5000, 3))
            .target(TestService.class,baseURL);

    TestService jsonService = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .options(new Request.Options(1000, 3500))
            .retryer(new Retryer.Default(5000, 5000, 3))
            .target(TestService.class,baseURL);

    @Test
    public void testGetCustomerName() throws Exception {
        assertEquals("hello123", textService.getCustomerName(123L));
    }

    @Test
    public void testUpdateCustomerName() throws Exception {
        Response response = jsonService.updateCustomer(4455L, "Ethan");
        assertEquals(200, response.status());
    }

    @Test
    public void testAddCustom() throws Exception {
        Response response = textService.addCustomer(4455L, "Ethan");
        assertEquals(200, response.status());
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        Response response = textService.deleteCustomer(123L);
        assertEquals(200, response.status());
    }

    @Test
    public void testAddCustomObj() throws Exception {
        Customer customer = new Customer();
        customer.setId(4455);
        customer.setName("Echo");
        Customer ret = jsonService.addCustomer(customer);
        assertEquals(customer.getName(),ret.getName());
    }
}