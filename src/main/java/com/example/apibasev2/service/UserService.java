package com.example.apibasev2.service;

import com.example.apibasev2.Security.JwtUtil;
import com.example.apibasev2.mapper.UserMapper;
import com.example.apibasev2.model.User;
import com.example.apibasev2.model.dto.UserRespontionDto.*;
import com.example.apibasev2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public List<UserDto> getAllUser(){
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach(e->userDtoList.add(UserMapper.mapFromUserToUserDto(e)));
        return userDtoList;
    }
    public UserDto createUser( CreateUserDto create){
        User user = UserMapper.mapFromCreateUserDtoToUser(create);
        String hp = passwordEncoder.encode(create.password());
        user.setPassword(hp);
        userRepository.save(user);
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
    public LoginResponseDto login(UserLoginDto dto) {
        User user = userRepository.findUsersByEmail(dto.email());

        if (user == null || !passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponseDto(token,UserMapper.mapFromUserToUserDto(user));
    }
}
