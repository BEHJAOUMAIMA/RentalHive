package com.example.rental_hive.service.impl;

import com.example.rental_hive.domain.EquipmentRental;
import com.example.rental_hive.repository.EquipmentRentalRepository;
import com.example.rental_hive.service.EquipmentRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EquipmentRentalServiceImpl implements EquipmentRentalService {

    @Autowired
    private EquipmentRentalRepository equipmentRentalRepository;

    @Override
    public EquipmentRental save(EquipmentRental equipmentRental) {
        return equipmentRentalRepository.save(equipmentRental);
    }

    @Override
    public List<EquipmentRental> findAll() {
        return equipmentRentalRepository.findAll();
    }

    @Override
    public Optional<EquipmentRental> findById(Long id) {
        return equipmentRentalRepository.findById(id);
    }

    @Override
    public EquipmentRental update(EquipmentRental equipmentRental) {
        Optional<EquipmentRental> equipment = equipmentRentalRepository.findById(equipmentRental.getId());
        if (equipment.isPresent()){
            return equipmentRentalRepository.save(equipmentRental);
        }
        return null;
    }

    @Override
    public void delete(EquipmentRental equipmentRental) {
        equipmentRentalRepository.delete(equipmentRental);
    }
}
