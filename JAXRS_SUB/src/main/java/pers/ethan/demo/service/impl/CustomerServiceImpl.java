package pers.ethan.demo.service.impl;

import io.swagger.annotations.Api;
import pers.ethan.demo.Customer;
import pers.ethan.demo.service.CustomerService;

import javax.ws.rs.core.Response;

/**
 * desc:
 * Created by huangzhe on 2017/4/22.
 */
@Api("/customer")
public class CustomerServiceImpl implements CustomerService {
    public String GetCustomerName(String id) {
        return "hello" + id;
    }

    public Response updateCustomer(Long id, String name){
        System.out.println("----invoking updateCustomer, Customer id: " + id + ", name: " + name);
        Response r;
        //if modify OK!
        if (id == 123) {
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }
        return r;
    }

    public Response addCustomer(Long id, String name){
        System.out.println("----invoking addCustomer, Customer id: " + id + ", name: " + name);
        Response r;
        r = Response.ok().build();
        return r;
    }

    public Customer addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer: " + customer);
        return customer;
    }
}
