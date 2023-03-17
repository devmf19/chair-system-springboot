package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.Event;
import com.devmf.chairSystem.model.EventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetail, Long> {

    List<EventDetail> findEventDetailByEvent(Event event);
}
