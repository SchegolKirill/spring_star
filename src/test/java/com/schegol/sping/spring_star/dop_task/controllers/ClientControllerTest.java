package com.schegol.sping.spring_star.dop_task.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schegol.sping.spring_star.dop_task.entity.Address;
import com.schegol.sping.spring_star.dop_task.entity.Client;
import com.schegol.sping.spring_star.dop_task.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addNewClient() throws Exception {
        Address address = new Address(1, "2",
                "3", "4", "5", 7, 8, 9);

        Client client = new Client(1, "Kirill", "1231231", "123123123", address, null);

        mockMvc.perform(postJson("/addnewclient", client))
                .andExpect(status().isOk());

//        mockMvc.perform(get("/addnewclient"))
//                .andExpect(status().isOk())
//                .andExpect(clientCheck("$", client));
    }

    @Test
    void getClient() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void getClients() {
    }

    @Test
    void deleteClient() {
    }

    public static MockHttpServletRequestBuilder postJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body);
            return post(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultMatcher clientCheck(String prefix, Client client) {
        return ResultMatcher.matchAll(
                jsonPath(prefix + ".id").value(client.getId()),
                jsonPath(prefix + ".name").value(client.getName()),
                jsonPath(prefix + ".inn").value(client.getInn()),
                jsonPath(prefix + ".phoneNumber").value(client.getPhoneNumber()),
                jsonPath(prefix + ".address").value(client.getAddress())
        );
    }
}