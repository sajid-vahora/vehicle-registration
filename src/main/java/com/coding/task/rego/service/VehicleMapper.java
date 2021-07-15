package com.coding.task.rego.service;

import com.coding.task.rego.model.Vehicle;
import com.coding.task.rego.io.swagger.model.VehicleRequest;
import com.coding.task.rego.io.swagger.model.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    VehicleResponse vehicleToVehicleResponse(Vehicle vehicle);

    Vehicle vehicleRequestToVehicle(VehicleRequest vehicleRequest);
}
