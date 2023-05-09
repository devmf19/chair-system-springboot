package com.devmf.chairSystem.model;

import com.devmf.chairSystem.security.model.User;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "event")
@Getter @Setter
@NoArgsConstructor
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "initial_date")
    private Date initialDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @Column(name  = "state")
    private String state;

    @Column(name = "observation")
    private String observation;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventDetail> eventDetails;

    public Event(long id, String name, Date initialDate, Date endDate, String state, String observation, User user, Customer customer) {
        this.id = id;
        this.name = name;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.state = state;
        this.observation = observation;
        this.user = user;
        this.customer = customer;
    }

    public Event(long id) {
        this.id = id;
    }
}
