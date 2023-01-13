package com.seresco.milena.authentication.service.domain.service.implementation;

import com.seresco.milena.authentication.service.domain.service.LoginService;
import com.seresco.milena.authentication.service.infrastructure.util.RealmInfo;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DefaultLoginService implements LoginService {

    private RealmInfo realmInfo;

    @Override
    public Object login(String username, String password) {
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", "3AeFHyfAEPa3ZDNncK4LizFSFkXEpYFX");
        clientCredentials.put("grant_type", "password");
        Configuration configuration =
                new Configuration("http://localhost:8080", "master", "admin-cli",
                        clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        AccessTokenResponse response =
                authzClient.obtainAccessToken(username, password);
        return ResponseEntity.ok(response);
    }
}
