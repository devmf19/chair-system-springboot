package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {
    private long id;

    @NotBlank
    private int type;

    @NotBlank
    private double amount;

    @NotBlank
    private String message;

    @NotBlank
    private String accountNumber;

    private long eventDetailId;

    private Timestamp createdAt;

    public TransactionDto(int type, double amount, String message, String accountNumber, long eventDetailId) {
        this.type = type;
        this.amount = amount;
        this.message = message;
        this.accountNumber = accountNumber;
        this.eventDetailId = eventDetailId;
    }
}
