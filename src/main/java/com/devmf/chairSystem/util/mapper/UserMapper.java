package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;
import com.devmf.chairSystem.security.model.User;
import com.devmf.chairSystem.security.service.implementation.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private RoleService roleService;

    public UserDto entityToDto(User user) {
        if(user == null )
            return null;

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setDui(user.getDui());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setRoles(
                user.getRoles()
                        .stream()
                        .map(role -> role.getRoleName().name())
                        .collect(Collectors.toSet())
        );

        return userDto;
    }

    public User dtoToEntity(UserDto userDto) {
        if(userDto == null )
            return null;

        User user = new User();
        user.setId(userDto.getId());
        user.setDui(userDto.getDui());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        if(userDto.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());

        user.setRoles(roles);
        return user;
    }
}
