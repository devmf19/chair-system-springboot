package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ProductDto {
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private long amount;
    private long stock;
}
