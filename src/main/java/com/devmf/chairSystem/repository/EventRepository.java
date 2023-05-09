package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT " +
                "e " +
            "FROM " +
                "Event e " +
            "WHERE " +
                "e.state <> 'CANCELADO'" +
            "AND e.initialDate BETWEEN :initialDate AND :endDate")
    List<Event> findEventsBetween(
            @Param("initialDate") Date initialDate,
            @Param("endDate") Date endDate
    );

    List<Event> findAllByState(String state);


}
