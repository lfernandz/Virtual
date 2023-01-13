package com.seresco.milena.authentication.service.domain.service;

import com.seresco.milena.authentication.service.domain.model.CreateUserRequest;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KeycloakAdminClientService {

    List<UserRepresentation> getUsers();

    ResponseEntity<String> createUser(CreateUserRequest createUserRequest);

    ResponseEntity<UserRepresentation> updateUser(String id, CreateUserRequest createUserRequest);

    void deleteUser(String id);
}
