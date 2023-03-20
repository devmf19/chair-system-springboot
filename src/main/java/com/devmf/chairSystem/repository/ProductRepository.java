package com.devmf.chairSystem.repository;

import com.devmf.chairSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT " +
                        "p.id AS productId, " +
                        "p.name AS productName, " +
                        "p.amount - COALESCE(r.reserved_amount, 0) AS available " +
                    "FROM " +
                        "product p " +
                        "LEFT JOIN (" +
                            "SELECT " +
                                "ed.id_product, " +
                                "SUM(ed.amount) AS reserved_amount " +
                            "FROM " +
                                "event_detail ed JOIN event e ON ed.id_event = e.id " +
                            "WHERE " +
                                "e.state <> 'CANCELADO' " +
                                "AND (e.initial_date BETWEEN :initialDate AND :endDate or e.end_date BETWEEN :initialDate AND :endDate) " +
                            "GROUP BY " +
                                "ed.id_product" +
                        ") r ON p.id = r.id_product",
            nativeQuery = true
    )
    List<Map<String, Object>> availableProducts(@Param("initialDate") String initialDate, @Param("endDate") String endDate);
}
