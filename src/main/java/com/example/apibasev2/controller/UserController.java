package com.example.apibasev2.controller;

import com.example.apibasev2.model.dto.UserRespontionDto.CreateUserDto;
import com.example.apibasev2.model.dto.UserRespontionDto.UpdateUserDto;
import com.example.apibasev2.model.dto.UserRespontionDto.UserDto;
import com.example.apibasev2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{uuid}")
    public UserDto getUserByUuid(@PathVariable String uuid){
        return userService.findUserByUuid(uuid);
    }
    @PostMapping("/create")
    public UserDto createUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto);
    }
    @PutMapping("update/{uuid}")
    public UserDto updateUserByUuid(@PathVariable String uuid,@RequestBody UpdateUserDto update){
        return userService.updateUserByUuid(uuid,update);
    }
    @DeleteMapping("delete/{uuid}")
    public UserDto deleteUserByUuid(@PathVariable String uuid){
        return userService.deleteUserByUuid(uuid);
    }
}
