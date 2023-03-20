package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DateRequest {
    private String initialDate;
    private String endDate;
}
