package com.example.rental_hive.service.impl;

import com.example.rental_hive.domain.Equipment;
import com.example.rental_hive.repository.EquipmentRepository;
import com.example.rental_hive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;


    @Override
    public Equipment save(@Valid Equipment equipment) {

        if (equipment.getId() != null){
            throw new IllegalArgumentException("Equipment ID must be null for save operation.");
        }
        if (equipment.getName() == null || equipment.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment name cannot be null or empty.");
        }
        if (equipment.getSerialNumber() == null) {
            throw new IllegalArgumentException("Serial number cannot be null.");
        }
        if (equipment.getCategory() == null) {
            throw new IllegalArgumentException("Equipment category cannot be null.");
        }
        if (equipment.getQuantity() == null || equipment.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number.");
        }
        if (equipment.getRentalCost() == null || equipment.getRentalCost() <= 0) {
            throw new IllegalArgumentException("Rental cost must be a positive number.");
        }
        return equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> findAll() {
        List<Equipment> equipmentList = equipmentRepository.findAll();

        if (equipmentList.isEmpty()) {
            throw new NoSuchElementException("No equipment found.");
        }

        return equipmentList;
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        Optional<Equipment> equipmentOptional = equipmentRepository.findById(id);

        if (equipmentOptional.isEmpty()) {
            throw new NoSuchElementException("Equipment not found with ID: " + id);
        }

        return equipmentOptional;
    }

    @Override
    public Equipment update(Equipment equipmentUpdated) {
        Long id = equipmentUpdated.getId();

        Optional<Equipment> existingEquipmentOptional = equipmentRepository.findById(id);

        if (existingEquipmentOptional.isPresent()) {
            Equipment existingEquipment = existingEquipmentOptional.get();

            if (!existingEquipment.getId().equals(equipmentUpdated.getId())) {
                throw new IllegalArgumentException("Cannot update equipment with different ID.");
            }

            existingEquipment.setName(equipmentUpdated.getName());
            existingEquipment.setSerialNumber(equipmentUpdated.getSerialNumber());
            existingEquipment.setCategory(equipmentUpdated.getCategory());
            existingEquipment.setQuantity(equipmentUpdated.getQuantity());
            existingEquipment.setRentalCost(equipmentUpdated.getRentalCost());

            return equipmentRepository.save(existingEquipment);
        } else {
            throw new NoSuchElementException("Equipment not found with ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Equipment> equipmentOptional = findById(id);

        if (equipmentOptional.isPresent()) {
            equipmentRepository.delete(equipmentOptional.get());
        } else {
            throw new NoSuchElementException("Equipment not found with ID: " + id);
        }
    }
}
