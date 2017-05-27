package pers.ethan.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * desc:
 * Created by huangzhe on 2017/4/16.
 */
@Path("/hello/")
@Produces("text/xml")
public interface HelloService {
    @GET
    @Path("/say/{id}/")
    String sayHello(@PathParam("id") String id);
}
