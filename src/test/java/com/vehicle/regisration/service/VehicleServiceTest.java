package com.vehicle.regisration.service;

import com.vehicle.regisration.exception.ResourceNotFoundException;
import com.vehicle.regisration.model.Vehicle;
import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.vehicle.regisration.io.swagger.model.VehicleResponse;
import com.vehicle.regisration.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private VehicleMapper vehicleMapper = new VehicleMapperImpl();

    @InjectMocks
    private VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository, vehicleMapper);

    @Test
    public void createNewVehicle() throws Exception {
        Mockito.when(vehicleRepository.save(ArgumentMatchers.any()))
                .thenReturn(new Vehicle(12,"HHH 888", "BMW",  null));
        VehicleResponse vehicle = vehicleService.createNewVehicle(getVehicleJsonRequest());
        Assertions.assertEquals(vehicle.getRegistrationNumber(), "HHH 888");
        Assertions.assertEquals(vehicle.getMake(), "BMW");
    }

    @Test
    public void getVehicleById() throws Exception {
        Mockito.when(vehicleRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(new Vehicle(12,"HHH 888", "BMW", null)));
        VehicleResponse vehicle = vehicleService.getVehicleById(12);
        Assertions.assertEquals(vehicle.getRegistrationNumber(), "HHH 888");
        Assertions.assertEquals(vehicle.getMake(), "BMW");
    }

    @Test
    public void getVehicleByIdWhenItDoesNotExist() throws Exception {
        Mockito.when(vehicleRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> vehicleService.getVehicleById(12),
                "Vehicle not found for the id :: 12");
    }

    private VehicleRequest getVehicleJsonRequest() {
        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setMake("Audi");
        vehicleRequest.setRegistrationNumber("HHH888");
        return vehicleRequest;
    }
}
