package com.devmf.chairSystem.security.model;

import com.devmf.chairSystem.security.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.sun.istack.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Getter @Setter
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

}
