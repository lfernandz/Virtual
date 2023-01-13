package com.seresco.milena.authentication.service.application;

import com.seresco.milena.authentication.service.domain.model.CreateUserRequest;
import com.seresco.milena.authentication.service.domain.service.KeycloakAdminClientService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/keycloak/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    private KeycloakAdminClientService keycloakAdminClientService;

    @GetMapping("/users")
    public List<UserRepresentation> getUsers() {
        return keycloakAdminClientService.getUsers();
    }

    @PostMapping("/new-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return keycloakAdminClientService.createUser(createUserRequest);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserRepresentation> updateUserDescriptionAttribute(
            @PathVariable String id,
            @RequestBody CreateUserRequest createUserRequest) {
        return keycloakAdminClientService.updateUser(id, createUserRequest);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(String id) {

    }
}
