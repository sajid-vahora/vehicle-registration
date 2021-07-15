package com.coding.task.rego.service;


import com.coding.task.rego.exception.BadRequestException;
import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.io.swagger.model.PersonRequest;
import com.coding.task.rego.io.swagger.model.PersonResponse;
import com.coding.task.rego.io.swagger.model.VehicleResponse;
import com.coding.task.rego.model.*;
import com.coding.task.rego.repository.PersonRepository;
import com.coding.task.rego.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    private VehicleRepository vehicleRepository;

    private PersonMapper personMapper;

    private VehicleMapper vehicleMapper;

    public PersonServiceImpl(PersonRepository personRepository, VehicleRepository vehicleRepository,
                             PersonMapper personMapper, VehicleMapper vehicleMapper) {
        this.personRepository = personRepository;
        this.vehicleRepository = vehicleRepository;
        this.personMapper = personMapper;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public PersonResponse getPersonById(Integer personId) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for the id :: " + personId));
        return getPersonResponse(person);
    }

    @Override
    public PersonResponse createNewPerson(PersonRequest personRequest) {
        Person person = personMapper.personRequestToPerson(personRequest);
        Person newPerson = personRepository.save(person);
        return getPersonResponse(newPerson);
    }

    @Override
    public void linkVehicle(Integer personId, Integer vehicleId) throws BadRequestException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new BadRequestException("Person not found with the id :: " + personId));
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new BadRequestException("Vehicle not found with the id :: " + vehicleId));
        try {
            personRepository.save(person.addVehicle(vehicle));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void unLinkVehicle(Integer personId, Integer vehicleId) throws BadRequestException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new BadRequestException("Person not found with the id :: " + personId));
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new BadRequestException("Vehicle not found with the id :: " + vehicleId));
        person.removeVehicle(vehicle);
        personRepository.save(person);
    }

    private PersonResponse getPersonResponse(Person person){
        PersonResponse personResponse = personMapper.personToPersonResponse(person);
        List<VehicleResponse> vehicleResponses = person.getVehicles().stream()
                .filter(vehicle -> vehicle != null)
                .map(vehicle -> vehicleMapper.vehicleToVehicleResponse(vehicle))
                .collect(Collectors.toList());
        personResponse.setVehicles(vehicleResponses);
        return personResponse;
    }

}
