package com.coding.task.rego.controller;

import com.coding.task.rego.exception.BadRequestException;
import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.io.swagger.api.VehicleApi;
import com.coding.task.rego.io.swagger.model.VehicleRequest;
import com.coding.task.rego.io.swagger.model.VehicleResponse;
import com.coding.task.rego.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T10:58:46.967Z")

@Controller
public class VehicleApiController implements VehicleApi {

    private static final Logger log = LoggerFactory.getLogger(VehicleApiController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VehicleService vehicleService;

    public ResponseEntity<VehicleResponse> vehicleGet(@ApiParam(value = "vehicle Id",required=true) @PathVariable("vehicleId") Integer vehicleId) throws ResourceNotFoundException {
        VehicleResponse vehicleResponse = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok().body(vehicleResponse);
    }

    public ResponseEntity<VehicleResponse> vehiclePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody VehicleRequest item) throws BadRequestException {
        VehicleResponse vehicleResponse = vehicleService.createNewVehicle(item);
        return ResponseEntity.created(getLocation(vehicleResponse)).build();
    }

    private URI getLocation(VehicleResponse vehicleResponse){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vehicleResponse.getVehicleId())
                .toUri();
    }

}
