package com.project.geeksworld.controllers;

import com.project.geeksworld.models.UserEntity;
import com.project.geeksworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserRepository userRepository;

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    @PostMapping
    public UserEntity signIn (@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PutMapping("/{userId}")
    public void update (@RequestBody UserEntity user){
    	userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

}