package com.vehicle.regisration.service;

import com.vehicle.regisration.model.Person;
import com.vehicle.regisration.io.swagger.model.PersonRequest;
import com.vehicle.regisration.io.swagger.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "personId", source = "person.id")
    PersonResponse personToPersonResponse(Person person);

    Person personRequestToPerson(PersonRequest personRequest);
}
