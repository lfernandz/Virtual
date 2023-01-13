package com.seresco.milena.authentication.service.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrentUser {

    private String userId;
    private String username;
    private String email;
    private List<String> roles;
}
