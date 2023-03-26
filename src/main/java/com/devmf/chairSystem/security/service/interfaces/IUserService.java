package com.devmf.chairSystem.security.service.interfaces;

import com.devmf.chairSystem.security.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {
    List<UserDto> getUsers();

    UserDto getUserById(long id);

    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(UserDto userDto);

    boolean validateUser(UserDto userDto);

    boolean existByUsername(String username);

    boolean existByDui(String dui);
}