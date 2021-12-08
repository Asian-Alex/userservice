package com.hcl.travel.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hcl.travel.model.UserDetails;

@Service
public interface UserService {
  
  UserDetails saveUser(UserDetails details);
  UserDetails deleteUser(UserDetails details);
  UserDetails findUser(UserDetails details);
  UserDetails updateUser(UserDetails details);
  List<UserDetails> findUsers();
}
