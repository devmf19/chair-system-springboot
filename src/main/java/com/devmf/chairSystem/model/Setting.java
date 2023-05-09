package com.devmf.chairSystem.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "setting")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nit")
    private String nit;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name="address")
    private String address;

    @ManyToOne()
    @JoinColumn(name = "money_id")
    private Money money;
}
