package com.devmf.chairSystem.security.service.implementation;

import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;
import com.devmf.chairSystem.security.model.User;
import com.devmf.chairSystem.security.repository.UserRepository;
import com.devmf.chairSystem.security.service.interfaces.IUserService;
import com.devmf.chairSystem.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveUser(UserDto userDto) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER));

        if(userDto.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN));

        User user = userMapper.dtoToEntity(userDto);
        user.setRoles(roles);

        userRepository.save(user);

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
    public User getByDui(String dui) {
        return userRepository.findByDui(dui);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
