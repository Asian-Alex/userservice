package com.hcl.travel.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.travel.model.UserDetails;
import com.hcl.travel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override // SAVE USER INFO
    public UserDetails saveUser(UserDetails details) {
        return userRepository.save(details);
    }

    @Override // GET USER VIA ID
    public Optional<UserDetails> findUserDetails(long userId_pk) {
        return userRepository.findById(userId_pk);
    }

    @Override // DELETES USER
    public Optional<UserDetails> deleteUser(long userId_pk) {
        Optional <UserDetails> deleted = userRepository.findById(userId_pk); // FIND THE ID YOU WANT TO DELETE
        userRepository.deleteById(userId_pk);
        return deleted;
    }

    @Override // UPDATES USER .. PUT
    public UserDetails updateUser(long userId_pk, UserDetails details) {
        Optional<UserDetails> update = userRepository.findById(userId_pk);
        if (update.isPresent()) {
            details.setUserId_pk(userId_pk);
            return userRepository.save(details);
        }
        return null;
    }

    @Override
    public List<UserDetails> findUsers(UserDetails details) {
        // TODO Auto-generated method stub
        return null;
    }

}