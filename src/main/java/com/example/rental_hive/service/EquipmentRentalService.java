package com.example.rental_hive.service;


import com.example.rental_hive.domain.EquipmentRental;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentRentalService {

    public EquipmentRental save(EquipmentRental equipmentRental);

    public List<EquipmentRental> findAll();

    public Optional<EquipmentRental> findById(Long id);

    public EquipmentRental update(EquipmentRental equipmentRental);

    public void delete(EquipmentRental equipmentRental);

}
