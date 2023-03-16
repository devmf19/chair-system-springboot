package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class UserDto {
    private long id;
    private String dui;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String phone;
}
