package com.devmf.chairSystem.security.repository;

import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
