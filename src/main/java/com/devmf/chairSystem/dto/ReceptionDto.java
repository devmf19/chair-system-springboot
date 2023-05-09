package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ReceptionDto {
    private long id;

    private String observations;

    private Timestamp createdAt;

    private List<ReceptionDetailDto> receptionDetails;

}
