package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    @NotBlank
    private String accountNumber;

    @NotBlank
    private double balance;

    private List<TransactionDto> transactions;
}
