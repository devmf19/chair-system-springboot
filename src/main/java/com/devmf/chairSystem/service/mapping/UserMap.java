package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.UserDto;
import com.devmf.chairSystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMap {
    public UserDto entityToDto(User user) {
        if(user == null ) {
            return null;
        }
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setDui(user.getDui());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());

        return userDto;
    }

    public User dtoToEntity(UserDto userDto) {
        if(userDto == null ) {
            return null;
        }
        User user = new User();

        user.setId(userDto.getId());
        user.setDui(userDto.getDui());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());

        return user;
    }
}
