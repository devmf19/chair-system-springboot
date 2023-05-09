package com.devmf.chairSystem.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "type")
    private int type;

    @NotNull
    @Column(name = "amount")
    @Min(0)
    private double amount;

    @Column(name = "message")
    private String message;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "event_detail_id")
    private long eventDetailId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction(long id, int type, double amount, String message, long eventDetailId, Account account) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.message = message;
        this.eventDetailId = eventDetailId;
        this.account = account;
    }
}
