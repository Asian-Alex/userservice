package com.hcl.travel.response;

import lombok.Data;

@Data
public class UserDetailsResponse {
  private String first_name;
  private String lastName;
  private String guid;
}
