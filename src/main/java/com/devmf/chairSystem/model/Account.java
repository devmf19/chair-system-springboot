package com.devmf.chairSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "account")
@Getter @Setter
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @NotNull
    @Column(name = "balance")
    @Min(0)
    private double balance;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
