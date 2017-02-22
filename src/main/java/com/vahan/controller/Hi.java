package com.vahan.controller;

/**
 * Created by vahan on 2/2/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vahan on 12/3/16.
 */
@Controller
@RequestMapping("/hi")
public class Hi {

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    @ResponseBody
    public String barev(){
        return "Hello secured user";
    }
}
