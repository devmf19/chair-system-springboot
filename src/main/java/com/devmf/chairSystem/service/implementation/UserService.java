package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.UserDto;
import com.devmf.chairSystem.repository.UserRepository;
import com.devmf.chairSystem.service.interfaces.IUserService;
import com.devmf.chairSystem.service.mapping.UserMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final UserMap userMap;


    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        return userRepository.findById(id)
                .map(userMap::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(
                userMap.dtoToEntity(userDto)
        );
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(
                userMap.dtoToEntity(userDto)
        );
    }

    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.delete(
                userMap.dtoToEntity(userDto)
        );
    }
}
