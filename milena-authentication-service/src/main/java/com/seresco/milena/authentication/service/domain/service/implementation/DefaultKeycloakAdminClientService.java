package com.seresco.milena.authentication.service.domain.service.implementation;

import com.seresco.milena.authentication.service.infrastructure.config.KeycloakPropertyReader;
import com.seresco.milena.authentication.service.domain.model.CreateUserRequest;
import com.seresco.milena.authentication.service.domain.service.KeycloakAdminClientService;
import com.seresco.milena.authentication.service.infrastructure.util.KeycloakInstance;
import com.seresco.milena.authentication.service.domain.message.RabbitMQMessageProducer;
import com.seresco.milena.authentication.service.security.CurrentUserProvider;
import com.seresco.milena.commons.service.domain.model.Notification;
import org.apache.commons.lang3.StringUtils;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class DefaultKeycloakAdminClientService implements KeycloakAdminClientService {

    @Value("${keycloak.resource}")
    private String keycloakClient;

    @Autowired
    private CurrentUserProvider currentUserProvider;

    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    @Autowired
    private KeycloakInstance keycloakInstance;

    @Autowired
    private RabbitMQMessageProducer messageProducer;

    @Override
    public List<UserRepresentation> getUsers(){
//        RealmResource realmResource = this.getRealm();
//        List<UserRepresentation> userRepresentations =realmResource.users().list();
        Keycloak keycloak = keycloakInstance.getKeycloakInstance();
        keycloak.tokenManager().getAccessToken();
        List<UserRepresentation> userRepresentations = keycloak.realm("MilenaCloud").users().list();
        return userRepresentations;
    }

    @Override
    public ResponseEntity<String> createUser(CreateUserRequest createUserRequest) {

        String validation = validateUserRequest(createUserRequest);
        if(null != validation)
            return ResponseEntity.badRequest().body(validation);

        CredentialRepresentation credentials = new CredentialRepresentation();
        credentials.setType(CredentialRepresentation.PASSWORD);
        credentials.setValue(createUserRequest.getPassword());
        credentials.setTemporary(false);

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(createUserRequest.getUsername());
        userRepresentation.setCredentials(Arrays.asList(credentials));
        userRepresentation.setEnabled(true);

        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("description", Arrays.asList("A test user"));
        userRepresentation.setAttributes(attributes);

        Keycloak keycloak = keycloakInstance.getKeycloakInstance();
        Response result = keycloak.realm("MilenaCloud").users().create(userRepresentation);

        Notification notification = new Notification();
        notification.setSubject("Nueva Cuenta");
        notification.setTo(createUserRequest.getEmail());
        notification.setMessage("Se le ha creado una cuenta nueva. " +
                "Su usuario es: " + createUserRequest.getUsername() + "" +
                " y su contraseña es: " + createUserRequest.getPassword());
        messageProducer.send(notification);

        return new ResponseEntity<>(HttpStatus.valueOf(result.getStatus()));

    }

    @Override
    public ResponseEntity<UserRepresentation> updateUser(String id, CreateUserRequest createUserRequest) {

        Keycloak keycloak = keycloakInstance.getKeycloakInstance();
        Optional<UserRepresentation> user = keycloak.realm("MilenaCloud").users().list().stream()
                .filter(u -> u.getId().equals(id)).findFirst();

        if (user.isPresent()) {
            UserRepresentation userRepresentation = user.get();
            UserResource userResource = keycloak.realm("MilenaCloud").users().get(userRepresentation.getId());
            Map<String, List<String>> attributes = new HashMap<>();
            attributes.put("description", Arrays.asList("A update user"));
            userRepresentation.setAttributes(attributes);
            userResource.update(userRepresentation);
            return ResponseEntity.ok().body(userRepresentation);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public void deleteUser(String id) {
        Keycloak keycloak = keycloakInstance.getKeycloakInstance();
        UsersResource users = keycloak.realm("MilenaCloud").users();
        users.get(id).remove();
//        users.delete(users.list().stream()
//                .filter(u -> u.getId().equals(id)).findFirst().get().getId());
//        users.search(id).stream()
//                .forEach(user -> domain.realm("MilenaCloud").users().delete(user.getId()));
    }

    private String validateUserRequest(CreateUserRequest createUserRequest) {
        if (StringUtils.isEmpty(createUserRequest.getUsername()))
            return "Empty username";
        if (StringUtils.isEmpty(createUserRequest.getPassword()))
            return "Empty password";
        if (StringUtils.isEmpty(createUserRequest.getEmail()))
            return "Empty email";
        if (StringUtils.isEmpty(createUserRequest.getFirstname()))
            return "Empty first name";
        if (StringUtils.isEmpty(createUserRequest.getLastname()))
            return "Empty last name";
        return null;
    }

}
