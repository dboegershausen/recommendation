package com.recommender.api.v1.controller;

import com.recommender.api.v1.dto.UserRequest;
import com.recommender.api.v1.dto.UserResponse;
import com.recommender.api.v1.mapper.UserMapper;
import com.recommender.domain.model.User;
import com.recommender.domain.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController("UserControllerV1")
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "User Management")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userInput, UriComponentsBuilder uriBuilder) {
        User user = userMapper.toUserEntity(userInput);
        user = userService.create(user);

        URI path = uriBuilder.path("/api/v1/users/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(path).body(userMapper.toUserResponse(user));
    }

}
