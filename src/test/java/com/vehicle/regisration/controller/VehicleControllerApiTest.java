package com.vehicle.regisration.controller;

import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads(){
    }

    @Test
    public void getVehicleByIdWhereVehicleDoesNotExist() throws Exception{
        mockMvc.perform(get("/api/v1/vehicle/1234")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createNewVehicle() throws Exception {
        mockMvc.perform(post("/api/v1/vehicle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getVehicleJsonRequest()))
                .andExpect(status().isCreated());
    }

    private String getVehicleJsonRequest() throws JsonProcessingException {
        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setMake("Audi");
        vehicleRequest.setRegistrationNumber("HHH888");
        return objectMapper.writeValueAsString(vehicleRequest);
    }
}
