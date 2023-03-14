package com.devmf.chairSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "event")
@Getter @Setter
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "days")
    private long days;
    @Column(name = "initial_date")
    private Timestamp initialDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @Column(name  = "state")
    private String state;
    @Column(name = "payment")
    private double payment;
    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
