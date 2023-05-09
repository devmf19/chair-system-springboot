package com.devmf.chairSystem.security.model;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalUser implements UserDetails {
    private String dui;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    protected Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String dui, String name, String lastname, String username, String password, String phone, Collection<? extends GrantedAuthority> authorities) {
        this.dui = dui;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.authorities = authorities;
    }

    public static PrincipalUser build(User user){
        List<GrantedAuthority> authorities1 = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());

        return new PrincipalUser(
                user.getDui(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                authorities1);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
