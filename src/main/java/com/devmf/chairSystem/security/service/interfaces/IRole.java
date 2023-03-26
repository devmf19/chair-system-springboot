package com.devmf.chairSystem.security.service.interfaces;

import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;

import java.util.Optional;

public interface IRole {
    Optional<Role> getByRoleName(RoleName roleName);

    void save(Role role);
}
