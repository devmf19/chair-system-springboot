package com.devmf.chairSystem.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class UserDto {
    private long id;

    @NotBlank
    private String dui;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String phone;

    private Set<String> roles = new HashSet<>();
}
