package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDto {
    private long id;
    private long days;
    private Date initialDate;
    private Date endDate;
    private String state;
    private double payment;
    private String observation;
    private Timestamp createdAt;
    private UserDto userDto;
    private CustomerDto customerDto;
}
