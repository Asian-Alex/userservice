package com.hcl.travel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserDetails {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "UIDPK")
  private Long uidpk;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;
  @Column(name = "GUID")
  private String guid;

}
