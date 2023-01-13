package com.seresco.milena.authentication.service.domain.config;

import com.seresco.milena.authentication.service.domain.model.KeycloakAdminClientConfig;
import com.seresco.milena.authentication.service.infrastructure.config.KeycloakAdminClientUtils;
import com.seresco.milena.authentication.service.infrastructure.config.KeycloakPropertyReader;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YamlFooPropertiesIntegrationTest {

    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    @Test
    public void whenFactoryProvidedThenYamlPropertiesInjected() {

        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);

//        assertEquals(keycloakPropertyReader.getProperty());

    }
}
