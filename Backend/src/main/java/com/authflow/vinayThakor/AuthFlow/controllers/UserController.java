package com.authflow.vinayThakor.AuthFlow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.authflow.vinayThakor.AuthFlow.dto.UserDTO;
import com.authflow.vinayThakor.AuthFlow.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.getUserByID(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        System.out.println("Received UserDTO: " + userDTO);
        UserDTO createdUser = userService.newUser(userDTO);
        System.out.println("Created UserDTO: " + createdUser);
        return ResponseEntity.ok(createdUser);
    }
}
