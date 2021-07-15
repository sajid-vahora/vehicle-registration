package com.vehicle.regisration.service;

import com.vehicle.regisration.model.Vehicle;
import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.vehicle.regisration.io.swagger.model.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    VehicleResponse vehicleToVehicleResponse(Vehicle vehicle);

    Vehicle vehicleRequestToVehicle(VehicleRequest vehicleRequest);
}
