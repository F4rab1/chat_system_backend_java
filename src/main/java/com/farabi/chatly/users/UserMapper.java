package com.farabi.chatly.users;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequestDto request, @MappingTarget User user);
    void updateProfile(ProfileDto dto, @MappingTarget Profile profile);
}
