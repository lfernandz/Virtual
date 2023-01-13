package com.seresco.milena.authentication.service.application;

import com.seresco.milena.authentication.service.domain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/token")
    public ResponseEntity<?> login (String username, String password) {
        return ResponseEntity.ok(loginService.login(username, password));
    }

}
