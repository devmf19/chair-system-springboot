package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IUserService {
    public List<UserDto> getUsers();

    public Optional<UserDto> getUserById(long id);

    public void saveUser(UserDto userDto);

    public void updateUser(UserDto userDto);

    public void deleteUser(UserDto userDto);
}
