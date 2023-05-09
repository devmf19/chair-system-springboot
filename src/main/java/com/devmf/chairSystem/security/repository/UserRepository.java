package com.devmf.chairSystem.security.repository;

import com.devmf.chairSystem.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByDui(String dui);
    User findByUsername(String username);
}
