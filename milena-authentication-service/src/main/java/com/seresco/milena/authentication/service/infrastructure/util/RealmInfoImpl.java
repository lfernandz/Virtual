package com.seresco.milena.authentication.service.infrastructure.util;

import com.seresco.milena.authentication.service.infrastructure.config.KeycloakAdminClientUtils;
import com.seresco.milena.authentication.service.infrastructure.config.KeycloakPropertyReader;
import com.seresco.milena.authentication.service.domain.model.KeycloakAdminClientConfig;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RealmInfoImpl implements RealmInfo{

    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    public RealmResource getRealm() {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);
        Keycloak keycloak = KeycloakAdminClientUtils.getKeycloakClient(principal.getKeycloakSecurityContext(), keycloakAdminClientConfig);

        // Get realm
        RealmResource realmResource = keycloak.realm(keycloakAdminClientConfig.getRealm());
        return realmResource;
    }

}
