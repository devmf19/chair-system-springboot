package com.devmf.chairSystem.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "reception_detail")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "amount")
    private long amount;

    @ManyToOne
    @JoinColumn(name = "event_detail_id")
    EventDetail eventDetail;

    @ManyToOne
    @JoinColumn(name = "reception_id")
    Reception reception;

}
