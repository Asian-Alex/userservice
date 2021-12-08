package com.hcl.travel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.travel.model.UserDetails;
import com.hcl.travel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails saveUser(UserDetails details) {
    return userRepository.save(details);
  }

  @Override
  public UserDetails deleteUser(UserDetails details) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserDetails findUser(UserDetails details) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserDetails updateUser(UserDetails details) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserDetails> findUsers() {
    // TODO Auto-generated method stub
    return null;
  }

}
