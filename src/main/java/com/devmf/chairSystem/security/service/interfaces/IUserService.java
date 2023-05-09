package com.devmf.chairSystem.security.service.interfaces;

import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(long id);

    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(UserDto userDto);

    boolean validateUser(UserDto userDto);

    User getByDui(String dui);

    User getByUsername(String username);
}
