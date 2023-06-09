package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Long> {
}
