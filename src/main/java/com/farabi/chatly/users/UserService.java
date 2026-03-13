package com.farabi.chatly.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userRepository.save(user);
    }
}
