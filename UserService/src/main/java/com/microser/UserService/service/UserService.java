package com.microser.UserService.service;
import com.microser.UserService.repository.UserRepository;
import com.microser.UserService.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean createUser(UserDetails userDetails) {

        UserDetails userDetails1 = userRepository.save(userDetails);

        if(userDetails1.getUserId() != null){
            return true;
        }
        return false;

    }

    public Optional<UserDetails> getUser(Integer id) {

       Optional<UserDetails> user =  userRepository.findById(id);

       return user;
    }
}
