package com.vehicle.regisration.service;

import com.vehicle.regisration.exception.BadRequestException;
import com.vehicle.regisration.exception.ResourceNotFoundException;
import com.vehicle.regisration.model.Vehicle;
import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.vehicle.regisration.io.swagger.model.VehicleResponse;
import com.vehicle.regisration.repository.VehicleRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    private VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleResponse getVehicleById(Integer vehicleId) throws ResourceNotFoundException {
         Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for the id :: " + vehicleId));
        System.out.println(vehicle);
         return vehicleMapper.vehicleToVehicleResponse(vehicle);
    }

    @Override
    public VehicleResponse createNewVehicle(VehicleRequest vehicleRequest) throws BadRequestException {
        if(vehicleRepository.existsByRegistrationNumber(vehicleRequest.getRegistrationNumber())) {
            throw new BadRequestException("Vehicle with registration number " + vehicleRequest.getRegistrationNumber()
                    + " is already present in the system");
        }
        try {
            Vehicle vehicle = vehicleMapper.vehicleRequestToVehicle(vehicleRequest);
            Vehicle newVehicle = vehicleRepository.save(vehicle);
            return vehicleMapper.vehicleToVehicleResponse(newVehicle);
        }catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Vehicle already present with registration number :: "
                    + vehicleRequest.getRegistrationNumber());
        }
    }
}
