package pers.ethan.demo.service;

import pers.ethan.demo.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * desc:
 * Created by huangzhe on 2017/4/22.
 */
@Path("/customer")
public interface CustomerService {
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    String getCustomerName(@PathParam("id") Long id);

    @PUT
    @Path("/update/{id}/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    Response updateCustomer(@PathParam("id") Long id, @PathParam("name") String name);

    @POST
    @Path("/add/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    Response addCustomer(@DefaultValue("123") @FormParam("id") Long id, @FormParam("name") String name);

    @POST
    @Path("/addObj/")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Customer addCustomer(Customer customer);

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    Response deleteCustomer(@PathParam("id") Long id);
}
