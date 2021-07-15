package com.vehicle.regisration.controller;

import com.vehicle.regisration.io.swagger.model.PersonRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads(){
    }

    @Test
    public void getPersonByIdWherePersonNotExist() throws Exception {
        mockMvc.perform(get("/api/v1/person/1234")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createNewPerson() throws Exception {
        mockMvc.perform(post("/api/v1/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getPersonJson()))
                .andExpect(status().isCreated());
    }

    private String getPersonJson() throws JsonProcessingException {
        PersonRequest personRequest = new PersonRequest();
        personRequest.firstName("firstName");
        personRequest.lastName("lastName");
        return objectMapper.writeValueAsString(personRequest);
    }
}