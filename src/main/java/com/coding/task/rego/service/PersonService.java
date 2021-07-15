package com.coding.task.rego.service;

import com.coding.task.rego.exception.BadRequestException;
import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.io.swagger.model.PersonRequest;
import com.coding.task.rego.io.swagger.model.PersonResponse;

public interface PersonService {

    PersonResponse getPersonById(Integer personId) throws ResourceNotFoundException;

    PersonResponse createNewPerson(PersonRequest request);

    void linkVehicle(Integer personId, Integer vehicleId) throws BadRequestException;

    void unLinkVehicle(Integer personId, Integer vehicleId) throws BadRequestException;

}
