package com.vehicle.regisration.service;

import com.vehicle.regisration.exception.BadRequestException;
import com.vehicle.regisration.exception.ResourceNotFoundException;
import com.vehicle.regisration.io.swagger.model.PersonRequest;
import com.vehicle.regisration.io.swagger.model.PersonResponse;

public interface PersonService {

    PersonResponse getPersonById(Integer personId) throws ResourceNotFoundException;

    PersonResponse createNewPerson(PersonRequest request);

    void linkVehicle(Integer personId, Integer vehicleId) throws BadRequestException;

    void unLinkVehicle(Integer personId, Integer vehicleId) throws BadRequestException;

}
