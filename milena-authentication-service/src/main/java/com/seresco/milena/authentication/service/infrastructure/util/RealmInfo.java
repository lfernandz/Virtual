package com.seresco.milena.authentication.service.infrastructure.util;

import org.keycloak.admin.client.resource.RealmResource;

public interface RealmInfo {

    RealmResource getRealm();

}
