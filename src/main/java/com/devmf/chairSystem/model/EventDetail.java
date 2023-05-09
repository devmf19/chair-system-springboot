package com.devmf.chairSystem.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "event_detail")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1)
    @Column(name = "amount")
    private long amount;

    @NotNull
    @Min(0)
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
