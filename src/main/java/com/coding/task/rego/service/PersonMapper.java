package com.coding.task.rego.service;

import com.coding.task.rego.model.Person;
import com.coding.task.rego.io.swagger.model.PersonRequest;
import com.coding.task.rego.io.swagger.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "personId", source = "person.id")
    PersonResponse personToPersonResponse(Person person);

    Person personRequestToPerson(PersonRequest personRequest);
}
