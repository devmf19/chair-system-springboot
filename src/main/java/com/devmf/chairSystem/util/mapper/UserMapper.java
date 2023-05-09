package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.model.Role;
import com.devmf.chairSystem.security.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto entityToDto(User user) {
        return user == null
                ? null
                : new UserDto(
                user.getDui(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                entityToDtoSet(user.getRoles())
        );
    }

    public User dtoToEntity(UserDto userDto) {
        return userDto == null
                ? null
                : new User(
                userDto.getDui(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getPhone()
        );
    }

    public Set<String> entityToDtoSet(Set<Role> roles) {
        return roles.stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.toSet());
    }
}
