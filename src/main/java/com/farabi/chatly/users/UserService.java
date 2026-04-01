package com.farabi.chatly.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto getUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto updateUser(String id, UpdateUserRequestDto request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }

        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }

        if (request.getProfile() != null) {
            if (user.getProfile() == null) {
                user.setProfile(new Profile());
            }

            Profile profile = user.getProfile();
            ProfileDto profileDto = request.getProfile();

            if (profileDto.getDisplayName() != null) {
                profile.setDisplayName(profileDto.getDisplayName());
            }

            if (profileDto.getBio() != null) {
                profile.setBio(profileDto.getBio());
            }
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
