package com.example.rental_hive.service.impl;

import com.example.rental_hive.domain.Equipment;
import com.example.rental_hive.repository.EquipmentRepository;
import com.example.rental_hive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EquipmentImplService implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;


    @Override
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public Equipment update(Equipment equipmentUpdated) {
        return equipmentRepository.save(equipmentUpdated);
    }

    @Override
    public void delete(Equipment equipment) {
        equipmentRepository.delete(equipment);
    }
}
