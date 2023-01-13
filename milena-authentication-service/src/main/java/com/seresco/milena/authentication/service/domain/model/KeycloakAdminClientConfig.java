package com.seresco.milena.authentication.service.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.PropertySource;

@Data
@Builder
public class KeycloakAdminClientConfig {

    private String serverUrl;
    private String realm;
    private String clientId;
    private String clientSecret;
}
