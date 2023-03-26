package com.devmf.chairSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.sun.istack.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "money")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Money implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "short_name")
    @NotNull
    private String shortName;

    @Column(name = "name")
    @NotNull
    private String name;
}
