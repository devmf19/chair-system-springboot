package com.devmf.chairSystem.security.service.implementation;

import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.repository.UserRepository;
import com.devmf.chairSystem.security.service.interfaces.IUserService;
import com.devmf.chairSystem.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDto)
                .peek(u -> u.setPassword(""))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToDto)
                .map(u -> {
                    u.setPassword("");
                    return u;
                })
                .orElse(null);
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(
                userMapper.dtoToEntity(userDto)
        );
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(
                userMapper.dtoToEntity(userDto)
        );
    }

    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.delete(
                userMapper.dtoToEntity(userDto)
        );
    }

    @Override
    public boolean validateUser(UserDto userDto) {
        return userDto == null;
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existByUsername(username);
    }

    @Override
    public boolean existByDui(String dui) {
        return userRepository.existByDui(dui);
    }
}
