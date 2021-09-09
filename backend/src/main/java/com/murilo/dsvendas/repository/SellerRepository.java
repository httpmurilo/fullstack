package com.murilo.dsvendas.repository;

import com.murilo.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
