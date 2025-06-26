package com.example.apibasev2.model.dto.UserRespontionDto;

import lombok.Builder;

@Builder
public record UserDto(
        String uuid,
        String userName,
        String email,
        String userRoles
) {
}
