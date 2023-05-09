package com.devmf.chairSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

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

    @JoinColumn(name = "account_id")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    private Account account;

    public Customer(String dui, String name, String lastname, String phone, String address, String email, Account account) {
        this.dui = dui;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.account = account;
    }
}
