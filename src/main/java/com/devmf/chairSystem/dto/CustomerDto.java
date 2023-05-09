package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class CustomerDto {
    @NotBlank
    private String dui;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    private String email;

    private AccountDto account;

}
