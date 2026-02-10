package com.Assignment.onlineLibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.onlineLibrary.entity.userEntity;
import com.Assignment.onlineLibrary.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<userEntity> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public userEntity login(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String password,
                            @RequestParam int months) {
        return userService.login(name, email, password, months);
    }
}


