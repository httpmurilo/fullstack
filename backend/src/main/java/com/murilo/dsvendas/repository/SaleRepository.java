package com.murilo.dsvendas.repository;

import com.murilo.dsvendas.dto.SaleSucessDTO;
import com.murilo.dsvendas.dto.SaleSumDTO;
import com.murilo.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT new com.murilo.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
                + " FROM Sale as obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.murilo.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + " FROM Sale as obj GROUP BY obj.seller")
    List<SaleSucessDTO> sucessGroupedBySeller();
}
