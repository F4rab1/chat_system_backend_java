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

    public UserDto registerUser(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = userMapper.toEntity(request);
        user.setRole(Role.USER);

        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto updateUser(String id, UpdateUserRequestDto request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.update(request, user);

        if (request.getProfile() != null) {
            if (user.getProfile() == null) {
                user.setProfile(new Profile());
            }
            userMapper.updateProfile(request.getProfile(), user.getProfile());
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public void changePassword(String id, ChangePasswordRequest request) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (!request.getOldPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password does not match");
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
