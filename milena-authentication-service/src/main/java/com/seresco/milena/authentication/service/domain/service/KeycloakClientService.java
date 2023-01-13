package com.seresco.milena.authentication.service.domain.service;

import com.seresco.milena.authentication.service.domain.model.CurrentUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KeycloakClientService {

    List<String> getCurrentUserRoles();

    CurrentUser getCurrentUsers();

    ResponseEntity<String> resetPassword(String id, String pass);

    Object getUserProfileOfLoggedUser();
}

