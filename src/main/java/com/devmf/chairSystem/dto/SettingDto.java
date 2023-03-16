package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class SettingDto {
    private long id;
    private String nit;
    private String name;
    private String phone;
    private String email;
    private String address;
    private MoneyDto moneyDto;
}
