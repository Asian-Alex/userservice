package com.hcl.travel.request;

import lombok.Data;

@Data
public class UserDetailsRequest {

    private String firstName;
    private String lastName;
    private String userId_pk;
    private String password;
    private String email;
    private boolean isAdmin; // is user admin
    private String guid;

}