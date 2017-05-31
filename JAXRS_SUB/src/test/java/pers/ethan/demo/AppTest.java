package pers.ethan.demo;

import junit.framework.TestCase;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    @Test
    public void testGetCustomerName() {
        Client client = ClientBuilder.newClient();
        Response res = client.target("http://localhost:8080/services/customer/id/123")
                .request("text/plain").get();
        String customerName = res.readEntity(String.class);
        assertEquals("hello123", customerName);
    }

    @Test
    public void testGetUpdateCustomer() {
        Client client = ClientBuilder.newClient();

        MultivaluedMap< String, String> formParameters = new MultivaluedHashMap();
        formParameters.add( "id", "4455" );
        formParameters.add( "name", "Ethan" );

        Response res = client.target("http://localhost:8080/services/customer/update/4455/Ethan")
                .request("text/plain").put(Entity.form(formParameters));
        assertEquals(200, res.getStatus());
    }

    @Test
    public void testAddCustomer() {
        Client client = ClientBuilder.newClient();

        MultivaluedMap< String, String> formParameters = new MultivaluedHashMap();
        formParameters.add( "id", "4455" );
        formParameters.add( "name", "Ethan" );

        Response res = client.target("http://localhost:8080/services/customer/add")
                .request("text/plain").post(Entity.form(formParameters));
        assertEquals(200, res.getStatus());
    }

/*    @Test
    public void testAddCustomerObj() {
        Client client = ClientBuilder.newClient();


        MultivaluedMap< String, String> formParameters = new MultivaluedHashMap();
        formParameters.add( "id", "4455" );
        formParameters.add( "name", "Ethan" );

        Customer customer = new Customer();
        customer.setId(4455);
        customer.setName("Echo");

        Response res = client.target("http://localhost:8080/services/customer/addObj")
                .request(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(formParameters), Response.class);
//        assertEquals("Ethan", res.readEntity(Customer.class).getName());
        System.out.println(res);
    }*/

    @Test
    public void testDeleteCustomer() {
        Client client = ClientBuilder.newClient();
        Response res = client.target("http://localhost:8080/services/customer/delete/123")
                .request("text/plain").delete();
        assertEquals(200, res.getStatus());
    }

}
