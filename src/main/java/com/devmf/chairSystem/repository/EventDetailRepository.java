package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.EventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetail, Long> {
}
