package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDto {
    private long id;
    private long days;
    private Timestamp initialDate;
    private Timestamp endDate;
    private String state;
    private double payment;
    private String observation;
    private UserDto userDto;
    private CustomerDto customerDto;
}
