package com.hcl.travel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hcl.travel.mapper.UserDetailsMapper;
import com.hcl.travel.model.UserDetails;
import com.hcl.travel.request.UserDetailsRequest;
import com.hcl.travel.service.UserService;

@Configuration
//@EnableAuthorizationServer  //Open the authentication Server
//@EnableResourceServer
@RestController
public class UserServiceController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsMapper userDetailsMapper;
    
    @PostMapping(path = "/user", consumes = "application/json; charset=UTF-8") // SAVES A NEW USER
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetailsRequest userDetailsRequest) throws JsonMappingException, JsonProcessingException
    {
        // VALIDATION
        
        // IF REQUEST IS VALID, CONVERT REQUIST INTO USERDETAILS
        System.out.println(userDetailsRequest);
        System.out.println("hello world");
        UserDetails userDetails = userDetailsMapper.getUserDetails(userDetailsRequest);
        
        System.out.println(userDetails);
        UserDetails savedUserDetails = userService.saveUser(userDetails);
        
        
        // CONVERT SAVED USERDETAILS OBJECT INTO USERDETAILSREPONSE
        System.out.println(savedUserDetails);
        return new ResponseEntity<>(userService.saveUser(userDetails), HttpStatus.OK);    
    }
    
    @GetMapping(path = "/user/{userId_pk}") // FETCHES USER INFO GIVEN PK
    public ResponseEntity<Optional<UserDetails>> findUser(@PathVariable long userId_pk) throws JsonMappingException, JsonProcessingException
    {
        return new ResponseEntity<>(userService.findUserDetails(userId_pk), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/user/{userId_pk}", consumes = "application/json; charset=UTF-8") // DELETES USER INFO USING PK
    public ResponseEntity<Optional<UserDetails>> deleteUser(@PathVariable long userId_pk) throws JsonMappingException, JsonProcessingException
    {
        return new ResponseEntity<>(userService.deleteUser(userId_pk), HttpStatus.OK);
    }
        
    @PutMapping(path = "/user/{userId_pk}", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails, @PathVariable long userId_pk) throws JsonMappingException, JsonProcessingException
    {
        return new ResponseEntity<>(userService.updateUser(userId_pk, userDetails), HttpStatus.OK);
    }
}