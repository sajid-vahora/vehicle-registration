package com.coding.task.rego.service;

import com.coding.task.rego.exception.BadRequestException;
import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.io.swagger.model.VehicleRequest;
import com.coding.task.rego.io.swagger.model.VehicleResponse;


public interface VehicleService {

    VehicleResponse getVehicleById(Integer vehicleId) throws ResourceNotFoundException;

    VehicleResponse createNewVehicle(VehicleRequest vehicleRequest) throws BadRequestException;

}
