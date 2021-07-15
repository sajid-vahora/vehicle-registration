package com.vehicle.regisration.service;

import com.vehicle.regisration.exception.BadRequestException;
import com.vehicle.regisration.exception.ResourceNotFoundException;
import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.vehicle.regisration.io.swagger.model.VehicleResponse;


public interface VehicleService {

    VehicleResponse getVehicleById(Integer vehicleId) throws ResourceNotFoundException;

    VehicleResponse createNewVehicle(VehicleRequest vehicleRequest) throws BadRequestException;

}
