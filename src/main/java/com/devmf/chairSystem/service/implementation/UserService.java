package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.UserDto;
import com.devmf.chairSystem.repository.UserRepository;
import com.devmf.chairSystem.service.interfaces.IUserService;
import com.devmf.chairSystem.service.mapping.UserMap;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private UserMap userMap = new UserMap();


    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(long id) {
        return Optional.of(
                userMap.entityToDto(
                        userRepository.findById(id).get()
                )
        );
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
