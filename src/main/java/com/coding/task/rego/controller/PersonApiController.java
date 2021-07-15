package com.coding.task.rego.controller;

import com.coding.task.rego.exception.BadRequestException;
import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.io.swagger.api.PersonApi;
import com.coding.task.rego.io.swagger.model.ModelApiResponse;
import com.coding.task.rego.io.swagger.model.PersonRequest;
import com.coding.task.rego.io.swagger.model.PersonResponse;
import com.coding.task.rego.model.RegistrationRequest;
import com.coding.task.rego.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-07T10:58:46.967Z")
@Validated
@Controller
public class PersonApiController implements PersonApi {

    private static final Logger log = LoggerFactory.getLogger(PersonApiController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonService personService;

    public ResponseEntity<Void> linkVehicle(
            @ApiParam(value = "person id",required=true) @PathVariable("personId") Integer personId,
            @ApiParam(value = "" ,required=true )  @Valid @RequestBody RegistrationRequest registrationRequest) throws BadRequestException {
        personService.linkVehicle(personId, registrationRequest.getVehicleId());
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<PersonResponse> personGet(@ApiParam(value = "person id",required=true) @PathVariable("personId") Integer personId) throws ResourceNotFoundException {
        PersonResponse personResponse = personService.getPersonById(personId);
        return ResponseEntity.ok().body(personResponse);
    }

    public ResponseEntity<ModelApiResponse> personPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PersonRequest item) {
        PersonResponse personResponse = personService.createNewPerson(item);
        return ResponseEntity.created(getLocation(personResponse)).build();
    }

    public ResponseEntity<Void> unLinkVehicle(
            @ApiParam(value = "person id",required=true) @PathVariable("personId") Integer personId,
            @ApiParam(value = "" ,required=true )  @Valid @RequestBody RegistrationRequest registrationRequest) throws BadRequestException {
        personService.unLinkVehicle(personId, registrationRequest.getVehicleId());
        return ResponseEntity.noContent().build();
    }

    private URI getLocation(PersonResponse personResponse){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personResponse.getPersonId())
                .toUri();
    }

}
