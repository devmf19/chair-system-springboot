package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.EventDetail;
import com.devmf.chairSystem.model.Reception;
import com.devmf.chairSystem.model.ReceptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReceptionDetailRepository extends JpaRepository<ReceptionDetail, Long> {
    Optional<ReceptionDetail> findByEventDetail(EventDetail eventDetail);

    List<ReceptionDetail> findAllByReception(Reception reception);
}
