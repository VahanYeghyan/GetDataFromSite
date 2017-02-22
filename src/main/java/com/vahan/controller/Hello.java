package com.vahan.controller;

/**
 * Created by vahan on 2/2/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vahan on 12/2/16.
 */
@Controller
@RequestMapping("/hello")
public class Hello {

    @RequestMapping(value = "/notSecured", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello user!";
    }


}
