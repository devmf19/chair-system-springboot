package com.devmf.chairSystem.dto;

import com.devmf.chairSystem.security.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ReceptionDto {
    private long id;

    private String observations;

}
