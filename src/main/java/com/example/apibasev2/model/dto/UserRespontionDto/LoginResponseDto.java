package com.example.apibasev2.model.dto.UserRespontionDto;

public record LoginResponseDto(
        String token,
        UserDto user
) { }
