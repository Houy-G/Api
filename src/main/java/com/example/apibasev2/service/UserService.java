package com.example.apibasev2.service;

import com.example.apibasev2.mapper.UserMapper;
import com.example.apibasev2.model.User;
import com.example.apibasev2.model.dto.UserRespontionDto.CreateUserDto;
import com.example.apibasev2.model.dto.UserRespontionDto.UpdateUserDto;
import com.example.apibasev2.model.dto.UserRespontionDto.UserDto;
import com.example.apibasev2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;
    public List<UserDto> getAllUser(){
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach(e->userDtoList.add(UserMapper.mapFromUserToUserDto(e)));
        return userDtoList;
    }
    public UserDto createUser( CreateUserDto create){
        userRepository.save(UserMapper.mapFromCreateUserDtoToUser(create));
        return UserMapper.mapFromUserToUserDto(UserMapper.mapFromCreateUserDtoToUser(create));
    }
    public UserDto updateUserByUuid(String uuid, UpdateUserDto update){
        User user1 = userRepository.findUserByUuid(uuid);
        user1.setUserName(update.userName());
        return UserMapper.mapFromUserToUserDto(userRepository.save(user1));
    }
    public UserDto findUserByUuid(String uuid){
        return UserMapper.mapFromUserToUserDto(userRepository.findUserByUuid(uuid));
    }
    public UserDto deleteUserByUuid(String uuid){
        userRepository.delete(userRepository.findUserByUuid(uuid));
        return UserMapper.mapFromUserToUserDto(userRepository.findUserByUuid(uuid));
    }
}
