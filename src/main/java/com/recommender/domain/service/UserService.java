package com.recommender.domain.service;

import com.recommender.domain.exception.UserAlreadyExistsException;
import com.recommender.domain.exception.UserWrongCurrentPasswordException;
import com.recommender.domain.model.User;
import com.recommender.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User create(User user) {
        Optional<User> optionalUser = repository.findByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

}
