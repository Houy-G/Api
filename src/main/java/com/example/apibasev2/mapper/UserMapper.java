package com.example.apibasev2.mapper;

import com.example.apibasev2.model.User;
import com.example.apibasev2.model.dto.UserRespontionDto.CreateUserDto;
import com.example.apibasev2.model.dto.UserRespontionDto.UserDto;

import java.util.UUID;

public class UserMapper {
    public static UserDto mapFromUserToUserDto(User user){
     return UserDto.builder()
             .uuid(user.getUuid())
             .userName(user.getUserName())
             .email(user.getEmail())
             .build();
    }
    public static User mapFromCreateUserDtoToUser(CreateUserDto create){
        return User.builder()
                .uuid(UUID.randomUUID().toString())
                .userName(create.userName())
                .email(create.email())
                .password(create.password())
                .build();
    }
}
