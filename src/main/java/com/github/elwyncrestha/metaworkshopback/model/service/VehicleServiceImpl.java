package com.github.elwyncrestha.metaworkshopback.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.elwyncrestha.metaworkshopback.model.entity.Vehicle;

import com.github.elwyncrestha.metaworkshopback.model.repository.VehicleRepository;
@Service
public class VehicleServiceImpl implements VehicleService  {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findOne(Long id) {
        return vehicleRepository.getOne(id);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Page<Vehicle> findAllPageable(Object t, Pageable pageable) {
        return null;
    }

    @Override
    public List<Vehicle> saveAll(List<Vehicle> list) {
        return vehicleRepository.saveAll(list);
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
