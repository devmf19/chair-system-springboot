package com.devmf.chairSystem.dto;

import com.devmf.chairSystem.security.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDto {
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private Date initialDate;

    @NotBlank
    private Date endDate;

    private String state;

    private String observation;

    private Timestamp createdAt;

    @NotBlank
    private UserDto user;

    @NotBlank
    private CustomerDto customer;

    private List<EventDetailDto> eventDetails;
}
