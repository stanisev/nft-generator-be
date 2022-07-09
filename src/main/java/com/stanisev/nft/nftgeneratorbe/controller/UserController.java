package com.stanisev.nft.nftgeneratorbe.controller;

import com.stanisev.nft.nftgeneratorbe.entity.UserEntity;
import com.stanisev.nft.nftgeneratorbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-user")
    public ResponseEntity<Object> addUser(@RequestParam String resource) {
        userRepository.save(new UserEntity(resource));
        return new ResponseEntity<Object>("Metamask User Created Successfully", HttpStatus.OK);
    }
}
