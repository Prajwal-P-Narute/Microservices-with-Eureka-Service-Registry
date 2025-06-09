package com.microser.UserService.controller;


import com.microser.UserService.entity.UserDetails;
import com.microser.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDetails userDetails){
        boolean userInfo = userService.createUser(userDetails);

        if(userInfo){
            return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User Not Created due to some error", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){

        Optional<UserDetails> user = userService.getUser(id);
        user.ifPresentOrElse(
                u -> System.out.println("Found user: " + u),
                () -> System.out.println("User with id " + id + " not found")
        );

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " +id+" Not found");
    }
}
