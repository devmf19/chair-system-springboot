package com.devmf.chairSystem.security.service.implementation;

import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;
import com.devmf.chairSystem.security.repository.RoleRepository;
import com.devmf.chairSystem.security.service.interfaces.IRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService implements IRole {
    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
