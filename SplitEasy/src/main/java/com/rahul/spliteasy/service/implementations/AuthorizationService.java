package com.rahul.spliteasy.service.implementations;

import com.rahul.spliteasy.configuration.security.LoggedInUser;
import com.rahul.spliteasy.persistence.entities.User;
import com.rahul.spliteasy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    LoggedInUser loggedInUser;

    @Autowired
    UserRepository userRepository;


    public User getAuthorizedUser() {
        return userRepository.findByEmail(loggedInUser.getUserEmail()).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
