package com.hcl.travel.response;

import lombok.Data;

@Data
public class UserDetailsResponse {
    private String firstName;
    private String lastName;
    private String guid;
}