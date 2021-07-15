package com.coding.task.rego.service;

import com.coding.task.rego.exception.ResourceNotFoundException;
import com.coding.task.rego.model.Person;
import com.coding.task.rego.io.swagger.model.PersonRequest;
import com.coding.task.rego.io.swagger.model.PersonResponse;
import com.coding.task.rego.model.Vehicle;
import com.coding.task.rego.repository.PersonRepository;
import com.coding.task.rego.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private VehicleRepository vehicleRepository;

    private VehicleMapper vehicleMapper = new VehicleMapperImpl();

    private PersonMapper personMapper = new PersonMapperImpl();

    @InjectMocks
    private PersonService personService = new PersonServiceImpl(
            personRepository, vehicleRepository, personMapper, vehicleMapper);


    @BeforeEach
    void setMockOutput() {

    }

    @Test
    public void getVehicleByIdWhereVehicleDoesNotExist() throws Exception {
        Mockito.when(personRepository.findById(ArgumentMatchers.same(123))).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> personService.getPersonById(123),
                "Person not found for the id :: 12");
    }

    @Test
    public void getPersonByIdWherePersonDoesExist() throws Exception {
        Person person = new Person(12,"firstName", "lastName", new HashSet<>());
        Mockito.when(personRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(person));
        PersonResponse personResponse = personService.getPersonById(12);
        Assertions.assertNotNull(personResponse.getPersonId());
        Assertions.assertEquals("firstName", personResponse.getFirstName());
        Assertions.assertEquals("lastName", personResponse.getLastName());
        Assertions.assertEquals(Collections.emptyList(), personResponse.getVehicles());
    }

    @Test
    public void createPerson() throws Exception {
        Person person = new Person(12,"firstName", "lastName", new HashSet<>());
        Mockito.when(personRepository.save(ArgumentMatchers.any()))
                .thenReturn(person);
        PersonResponse personResponse = personService.createNewPerson(getPersonRequest());
        Assertions.assertEquals(12, personResponse.getPersonId());
        Assertions.assertEquals("firstName", personResponse.getFirstName());
        Assertions.assertEquals("lastName", personResponse.getLastName());
        Assertions.assertEquals(Collections.emptyList(), personResponse.getVehicles());
    }

    @Test
    public void linkPerson() throws Exception {
        Vehicle vehicle = new Vehicle(1,"BMW", "HHH 888", null);
        Person person = new Person(12,"firstName", "lastName", new HashSet<>());
        Mockito.when(vehicleRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(vehicle));
        Mockito.when(personRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(person));
        Assertions.assertDoesNotThrow(() -> personService.linkVehicle(12, 1));
    }

    @Test
    public void unLinkPerson() throws Exception {
        Person person = new Person(12,"firstName", "lastName", new HashSet<>());
        Vehicle vehicle = new Vehicle(1,"BMW", "HHH 888", person);
        person.addVehicle(vehicle);
        Mockito.when(vehicleRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(vehicle));
        Mockito.when(personRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(person));
        Assertions.assertDoesNotThrow(() -> personService.unLinkVehicle(12, 1));
    }

    private PersonRequest getPersonRequest(){
        PersonRequest personRequest = new PersonRequest();
        personRequest.setFirstName("firstName");
        personRequest.setLastName("lastName");
        return personRequest;
    }
}
