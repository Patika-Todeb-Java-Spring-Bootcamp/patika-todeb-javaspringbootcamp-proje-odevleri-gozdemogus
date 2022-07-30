package com.patika.springbootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(name = "welcome", path = "/welcome")
    public String welcomeMessageAPI() {
        String welcomeMsg = "<center><h1><FONT COLOR=\"#DB70DB\">Welcome to the Second Hand App</h1></center>";
        return welcomeMsg;
        //  ResponseModel responseModel = new ResponseModel();
        //  responseModel.setWelcomeMessage(welcomeMsg);
        //  return responseModel;
    }
}
