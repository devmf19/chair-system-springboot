package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IUserService {
    public List<User> getUsers();

    public Optional<User> getUserById(long id);

    public void saveUser(User User);

    public void updateUser(User User);

    public void deleteUser(User User);
}
