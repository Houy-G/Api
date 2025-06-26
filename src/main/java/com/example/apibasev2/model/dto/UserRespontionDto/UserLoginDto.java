package com.example.apibasev2.model.dto.UserRespontionDto;

import lombok.Data;
import lombok.Getter;

public record UserLoginDto(
    String email,
    String password
) { }
