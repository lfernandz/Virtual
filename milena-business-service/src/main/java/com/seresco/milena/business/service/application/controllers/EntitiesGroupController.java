package com.seresco.milena.business.service.application.controllers;

import com.seresco.milena.business.service.domain.model.EntitiesGroup;
import com.seresco.milena.business.service.domain.service.EntitiesGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entities/group")
public class EntitiesGroupController {

    @Autowired
    private EntitiesGroupService service;

    @GetMapping("/all")
    public List<EntitiesGroup> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntitiesGroup finById(Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    public EntitiesGroup create(EntitiesGroup entitiesGroup){
        return service.create(entitiesGroup);
    }

    @PutMapping("/update/{id}")
    public EntitiesGroup update(Long id, EntitiesGroup entitiesGroup){
        return service.update(id, entitiesGroup);
    }

    @PutMapping("/change-status")
    public boolean changeStatus(Long id){
        return false;
    }

}
