package com.recommender.api.v1.mapper;

import com.recommender.api.v1.dto.*;
import com.recommender.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private ModelMapper modelMapper;

    public UserMapper() {
        modelMapper = new ModelMapper();
    }

    public User toUserEntity(UserRequest user) {
        return modelMapper.map(user, User.class);
    }

    public UserResponse toUserResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

}
