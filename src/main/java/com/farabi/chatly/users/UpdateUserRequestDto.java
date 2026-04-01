package com.farabi.chatly.users;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    @Size(min = 3, message = "Username must be at least 3 characters")
    private String username;

    @Size(min = 8, message = "Password must be at least 3 characters")
    private String password;

    private ProfileDto profile;
}
