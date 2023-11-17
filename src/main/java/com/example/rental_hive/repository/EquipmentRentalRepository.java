package com.example.rental_hive.repository;

import com.example.rental_hive.domain.EquipmentRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRentalRepository extends JpaRepository<EquipmentRental, Long> {
}
