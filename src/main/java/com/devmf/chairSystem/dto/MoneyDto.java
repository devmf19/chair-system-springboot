package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter @Setter
public class MoneyDto {
    private long id;
    @NotNull
    @NotEmpty
    private String shortName;
    @NotNull
    @NotEmpty
    private String name;
}
