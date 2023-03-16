package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String dui;
    private String name;
    private String lastname;
    private String phone;
    private String address;
    private String email;
}
