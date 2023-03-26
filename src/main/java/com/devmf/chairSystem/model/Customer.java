package com.devmf.chairSystem.model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "dui", unique = true)
    private String dui;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "balance")
    @Min(0)
    private double balance;
}
