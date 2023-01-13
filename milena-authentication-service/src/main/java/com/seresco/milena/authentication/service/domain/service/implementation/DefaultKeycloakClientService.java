package com.seresco.milena.authentication.service.domain.service.implementation;

import com.seresco.milena.authentication.service.domain.model.CurrentUser;
import com.seresco.milena.authentication.service.domain.service.KeycloakClientService;
import com.seresco.milena.authentication.service.infrastructure.util.RealmInfo;
import com.seresco.milena.authentication.service.security.CurrentUserProvider;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultKeycloakClientService implements KeycloakClientService {

    @Value("${keycloak.resource}")
    private String keycloakClient;

    @Autowired
    private CurrentUserProvider currentUserProvider;

    private RealmInfo realmInfo;

    @Override
    public List<String> getCurrentUserRoles() {
        return currentUserProvider.getCurrentUser().getRoles();
    }

    @Override
    public CurrentUser getCurrentUsers() {
        return currentUserProvider.getCurrentUser();
    }

    @Override
    public ResponseEntity<String> resetPassword(String id, String pass) {

        RealmResource realmResource = realmInfo.getRealm();

        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(pass);
        cred.setTemporary(false);

        UsersResource usersResource = realmResource.users();
        CurrentUser currentUser = currentUserProvider.getCurrentUser();
        UserResource userResource = usersResource.get(currentUser.getUserId());
        userResource.resetPassword(cred);

//        realmResource.users().get(id).resetPassword(cred);
        return ResponseEntity.ok("Success");
    }

    @Override
    public Object getUserProfileOfLoggedUser() {

        RealmResource realmResource = realmInfo.getRealm();
        UsersResource usersResource = realmResource.users();
        CurrentUser currentUser = currentUserProvider.getCurrentUser();
        UserResource userResource = usersResource.get(currentUser.getUserId());
//        UserResource userResource = usersResource.get(currentUserProvider.getCurrentUser().getUserId());
        UserRepresentation userRepresentation = userResource.toRepresentation();

        return userRepresentation;
    }

}
