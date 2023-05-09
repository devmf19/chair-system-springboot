package com.devmf.chairSystem.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "reception")
@Getter @Setter
@NoArgsConstructor
public class Reception implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "observations")
    private String observations;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "reception", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReceptionDetail> receptionDetails;

    public Reception(long id, String observations) {
        this.id = id;
        this.observations = observations;
    }
}
