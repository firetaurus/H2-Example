package com.alushkja.h2example.controllers;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/users")
@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> getAll(){
        return service.findAll();
    }


}
