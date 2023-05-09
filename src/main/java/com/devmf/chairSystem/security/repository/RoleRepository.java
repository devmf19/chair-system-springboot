package com.devmf.chairSystem.security.repository;

import com.devmf.chairSystem.security.enums.RoleName;
import com.devmf.chairSystem.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
