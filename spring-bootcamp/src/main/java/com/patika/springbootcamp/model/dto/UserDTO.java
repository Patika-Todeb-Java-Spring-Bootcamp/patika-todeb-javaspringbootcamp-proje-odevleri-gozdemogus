package com.patika.springbootcamp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String surname;
    private String about;
    private String email;
    private String address;
    private String phone;
    private String username;
}
