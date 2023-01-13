package com.seresco.milena.authentication.service.application;

import com.seresco.milena.authentication.service.domain.model.CurrentUser;
import com.seresco.milena.authentication.service.domain.service.KeycloakClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/keycloak", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeycloakController {

    @Autowired
    private KeycloakClientService keycloakClientService;

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(path = "/roles")
    public Collection<String> rolesOfCurrentUser() {
        return keycloakClientService.getCurrentUserRoles();
    }

    @GetMapping(path = "/user")
    public CurrentUser currentUser() {
        return keycloakClientService.getCurrentUsers();
    }

    @PostMapping(path = "/reset-password/{id}")
    public ResponseEntity<String> restPassword(@PathVariable String id, @RequestParam String pass) {
        return keycloakClientService.resetPassword(id, pass);
    }

    @GetMapping(path = "/profile")
    public Object profileOfCurrentUser() {
        return keycloakClientService.getUserProfileOfLoggedUser();
    }

}
