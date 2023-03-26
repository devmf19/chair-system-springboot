package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ReceptionDetailDto {
    private long id;

    @NotBlank
    private long amount;

    @NotBlank
    private EventDetailDto eventDetailDto;

    @NotBlank
    private ReceptionDto receptionDto;
}
