package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter @Setter
public class MoneyDto {
    private long id;
    @NotBlank
    private String shortName;
    @NotBlank
    private String name;
}
