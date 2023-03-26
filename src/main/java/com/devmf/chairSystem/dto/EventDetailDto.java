package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDetailDto {
    private long id;

    @NotBlank
    private long amount;

    @NotBlank
    private double price;

    @NotBlank
    private EventDto eventDto;

    @NotBlank
    private ProductDto productDto;
}
