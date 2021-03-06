/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.vehicle.regisration.io.swagger.api;

import com.vehicle.regisration.exception.BadRequestException;
import com.vehicle.regisration.exception.ResourceNotFoundException;
import com.vehicle.regisration.io.swagger.model.ModelApiResponse;
import com.vehicle.regisration.io.swagger.model.VehicleRequest;
import com.vehicle.regisration.io.swagger.model.VehicleResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T10:58:46.967Z")

@Validated
@Api(value = "vehicle", description = "the vehicle API")
@RequestMapping(value = "/api/v1")
public interface VehicleApi {

    @ApiOperation(value = "", nickname = "vehicleGet", notes = "", response = VehicleResponse.class, tags={ "Vehicle", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = VehicleResponse.class),
        @ApiResponse(code = 400, message = "Invalid Data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/vehicle/{vehicleId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<VehicleResponse> vehicleGet(@ApiParam(value = "vehicle Id",required=true) @PathVariable("vehicleId") Integer vehicleId) throws ResourceNotFoundException;


    @ApiOperation(value = "", nickname = "vehiclePost", notes = "creates a Vehicle", response = ModelApiResponse.class, tags={ "Vehicle", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 400, message = "Invalid Order"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/vehicle",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<VehicleResponse> vehiclePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody VehicleRequest item) throws BadRequestException;

}
