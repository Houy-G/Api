package com.example.apibasev2.model.dto.UserRespontionDto;

public record CreateUserDto(
        String userName,
        String email,
        String password
) { }
