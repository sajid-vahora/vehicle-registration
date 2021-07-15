package com.vehicle.regisration.controller;

import com.vehicle.regisration.io.swagger.model.VehicleResponse;
import com.vehicle.regisration.service.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerMockitoTest {

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleApiController vehicleApiController;

    @Test
    public void getVehicleByIdWhereVehicleDoesExist() throws Exception {
        Mockito.when(vehicleService.getVehicleById(ArgumentMatchers.same(12))).thenReturn(getVehicleResponse());
        ResponseEntity<VehicleResponse> vehicleResponseResponseEntity = vehicleApiController.vehicleGet(12);
        Assertions.assertEquals(vehicleResponseResponseEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(vehicleResponseResponseEntity.getBody().getVehicleId(), 12);
        Assertions.assertEquals(vehicleResponseResponseEntity.getBody().getRegistrationNumber(), "HHH 888");
        Assertions.assertEquals(vehicleResponseResponseEntity.getBody().getMake(), "BMW");
    }

    private VehicleResponse getVehicleResponse(){
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setVehicleId(12);
        vehicleResponse.setRegistrationNumber("HHH 888");
        vehicleResponse.setMake("BMW");
        return vehicleResponse;
    }
}
