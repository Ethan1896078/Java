package pers.ethan.client;

import feign.Feign;
import feign.Request;
import feign.Retryer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HelloService service = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(HelloService.class, "http://127.0.0.1:9000");
        System.out.println( service.getOwner("123") );
    }
}
