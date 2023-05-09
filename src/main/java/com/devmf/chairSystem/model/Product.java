package com.devmf.chairSystem.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "amount", columnDefinition = "int default'0'")
    private long amount;

    @Column(name = "stock")
    private long stock;

    public Product(long id) {
        this.id = id;
    }
}
