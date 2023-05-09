package com.devmf.chairSystem.security.service.implementation;

import com.devmf.chairSystem.security.model.PrincipalUser;
import com.devmf.chairSystem.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.getByUsername(username);
        return PrincipalUser.build(user);
    }
}
