package com.github.elwyncrestha.metaworkshopback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.elwyncrestha.metaworkshopback.model.entity.Vehicle;
import com.github.elwyncrestha.metaworkshopback.model.service.VehicleService;

@RestController
@RequestMapping(VehicleController.API)
public class VehicleController {

    static final String API = "v1/vehicle";

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.save(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
