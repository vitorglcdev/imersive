package com.example.imersive.controllers;

import com.example.imersive.models.User;
import com.example.imersive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers(){
        return  service.findAll();
    }
}
