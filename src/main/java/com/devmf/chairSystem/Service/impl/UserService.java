package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IUserService;
import com.devmf.chairSystem.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveUser(User User) {

    }

    @Override
    public void updateUser(User User) {

    }

    @Override
    public void deleteUser(User User) {

    }
}
