package com.seresco.milena.authentication.service.domain.model;

import lombok.Data;

@Data
public class CreateUserRequest {

    String username;
    String password;
    String email;
    String firstname;
    String lastname;

}
