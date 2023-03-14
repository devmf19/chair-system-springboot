package com.devmf.chairSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount")
    private long amount;
    @Column(name = "stock")
    private long stock;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}