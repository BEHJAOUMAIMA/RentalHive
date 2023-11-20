package com.example.rental_hive.web.rest;


import com.example.rental_hive.domain.Equipment;
import com.example.rental_hive.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/equipments")
public class EquipmentRest {

    private final EquipmentService equipmentService;


    public EquipmentRest( EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @PostMapping("/save")
    public Equipment save(@RequestBody @Valid Equipment equipment){
        return equipmentService.save(equipment);
    }

    @GetMapping("/")
    public List<Equipment> findAll() {
        return equipmentService.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Equipment> findById(@PathVariable("id") Long id) {
        return equipmentService.findById(id);
    }

    @PutMapping("/update")
    public Equipment update(@RequestBody @Valid Equipment equipmentUpdated){
        return equipmentService.update(equipmentUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        equipmentService.delete(id);
    }
}
