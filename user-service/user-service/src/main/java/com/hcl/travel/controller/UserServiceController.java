package com.hcl.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hcl.travel.mapper.UserDetailsMapper;
import com.hcl.travel.model.UserDetails;
import com.hcl.travel.request.UserDetailsRequest;
import com.hcl.travel.response.UserDetailsResponse;
import com.hcl.travel.service.UserService;

@RestController
public class UserServiceController {
  
  @Autowired
  private UserService userService;
  @Autowired
  private UserDetailsMapper userDetailsMapper;
  
  @PostMapping(path = "/user", consumes = "application/json; charset=UTF-8")
  public ResponseEntity<UserDetailsResponse> createUser(@RequestBody UserDetailsRequest userDetailsRequest)
      throws JsonMappingException, JsonProcessingException {
    //validatation
    
    System.out.println(userDetailsRequest);
    UserDetails userDetails = userDetailsMapper.getUserDetails(userDetailsRequest);
   
    System.out.println(userDetails);
    UserDetails savedUserDetails = userService.saveUser(userDetails);
   
    System.out.println(savedUserDetails);
    UserDetailsResponse userDetailsResponse = userDetailsMapper.getUserDetailsResponse(savedUserDetails);
    System.out.println("userDetailsResponse ["+userDetailsResponse+"]");
    return new ResponseEntity<>(userDetailsResponse, HttpStatus.OK);
  }
  
  
}
