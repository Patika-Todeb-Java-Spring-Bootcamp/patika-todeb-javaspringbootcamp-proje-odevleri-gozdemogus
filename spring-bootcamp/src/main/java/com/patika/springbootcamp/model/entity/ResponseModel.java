package com.patika.springbootcamp.model.entity;

public class ResponseModel {
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    String welcomeMessage;
}
