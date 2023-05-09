package com.devmf.chairSystem.security.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "dui", unique = true)
    private String dui;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String dui, String name, String lastname, String username, String password, String phone) {
        this.dui = dui;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}