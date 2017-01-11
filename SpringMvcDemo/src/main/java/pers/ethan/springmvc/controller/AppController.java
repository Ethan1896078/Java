package pers.ethan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * desc:
 * Created by huangzhe on 2016/11/18.
 */
@Controller
@RequestMapping("/api")
public class AppController {
    @ResponseBody
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(@RequestParam String userName){
        return "Hello " + userName;
    }

}
