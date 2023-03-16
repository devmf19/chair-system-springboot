package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ReceptionDto {
    private long id;
    private String observations;
    private EventDto eventDto;
    private UserDto userDto;
}
