package com.seresco.milena.commons.service.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Notification implements Serializable {

    private String subject;
    private String message;
    private String to;
    private List<String> emails;

}
