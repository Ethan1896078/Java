package pers.ethan.client;

import feign.Param;
import feign.RequestLine;

/**
 * desc:
 * Created by huangzhe on 2017/4/16.
 */
public interface HelloService {
    @RequestLine("GET /hello/say/{name}")
    String getOwner(@Param(value = "name") String name);
}
