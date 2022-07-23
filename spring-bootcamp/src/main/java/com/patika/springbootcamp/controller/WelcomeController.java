package com.patika.springbootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(name = "welcome", path = "/welcome")
    public String welcomeMessageAPI() {
        String welcomeMsg = "<h1>Welcome to the Second Hand App</h1>";
        return welcomeMsg;
        //  ResponseModel responseModel = new ResponseModel();
        //  responseModel.setWelcomeMessage(welcomeMsg);
        //  return responseModel;
    }
}
