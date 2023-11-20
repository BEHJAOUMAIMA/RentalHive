package com.example.rental_hive.service;

import com.example.rental_hive.domain.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentService {

    public Equipment save(Equipment equipment);

    public List<Equipment> findAll();

    public Optional<Equipment> findById(Long id);

    public Equipment update(Equipment equipmentUpdated);

    public void delete(Long id);

}
