package com.recommender.core.security.service;

import com.recommender.domain.model.User;
import com.recommender.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findByEmail(userName);
        return optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
    }

    public UserDetails loadUserById(Long userId) {
        Optional<User> possibleUser = repository.findById(userId);
        return possibleUser.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));
    }

}
