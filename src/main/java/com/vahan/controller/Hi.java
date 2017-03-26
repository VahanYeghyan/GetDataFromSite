package com.vahan.controller;

/**
 * Created by vahan on 2/2/17.
 */

import com.vahan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

/**
 * Created by vahan on 12/3/16.
 */
@Controller
@RequestMapping("/hi")
public class Hi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    @ResponseBody
    public String barev(){
        return "Hello secured user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(
            @FormParam("username") String username,
            @FormParam("password") String password) {

        userService.addUser(username,password);


        return Response.status(200)
                .entity("addUser is called, username : " + username + ", password : " + password)
                .build();

    }
}
