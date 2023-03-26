package com.devmf.chairSystem.dto;

import com.devmf.chairSystem.security.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDto {
    private long id;

    @NotBlank
    private Date initialDate;

    @NotBlank
    private Date endDate;

    @NotBlank
    private String state;

    private double payment;

    @NotBlank
    private String observation;

    private int resolved;

    private Timestamp createdAt;

    @NotBlank
    private UserDto userDto;

    @NotBlank
    private CustomerDto customerDto;
}
