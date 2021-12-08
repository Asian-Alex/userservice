package com.hcl.travel.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "USER_ID_PK") // primary key & not required to take from user 
    private long userId_pk;

    @Column(name = "FIRST_NAME") //user first name
    private String firstName;

    @Column(name = "LAST_NAME") // user last name
    private String lastName;

    @Column(name = "PASSWORD") // user password
    private String password;

    @Column(name = "EMAIL") // user email
    private String email;

    @Column(name = "ADMIN")
    private boolean isAdmin; // is user admin

    @Column(name = "GUID")
    private String guid;


    public void setUserId_pk(long userId_pk) {
        this.userId_pk = userId_pk;
    }
}