package com.farabi.chatly.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
    private String displayName;

    private String bio;

    private String avatarUrl;
}
