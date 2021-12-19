package com.schegol.sping.spring_star.dop_task.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schegol.sping.spring_star.dop_task.converters.ClientConverter;
import com.schegol.sping.spring_star.dop_task.dto.ClientDTO;
import com.schegol.sping.spring_star.dop_task.entity.Address;
import com.schegol.sping.spring_star.dop_task.entity.Client;
import com.schegol.sping.spring_star.dop_task.entity.Order;
import com.schegol.sping.spring_star.dop_task.repositories.ClientRepository;
import com.schegol.sping.spring_star.dop_task.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private ClientConverter clientConverter;

    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addNewClient() throws Exception {
        Address address = new Address("2","3", "4",
                "5", 7, 8, 9);

        Client client = new Client( "Kirill", "1231231",
                "123123123", address, null);

        mockMvc.perform(postJson("/client/addnewclient", client))
                .andExpect(status().isOk());


    }

    @Test
    void getClient() throws Exception{
//        String stringId = "id";
//        String url = "/client/getclient/"+stringId;
//        Integer id = Integer.parseInt(stringId);
        mockMvc.perform(get("/client/getclient/2"))
                .andExpect(status().isOk())
                .andExpect(clientCheck("$", clientController.getClient(2)));
    }

    @Test
    void updateClient() throws Exception {
        Address testAddress1 = new Address("2", "3", "4",
                "5", 7, 8, 9);

        Client testClient1 = new Client("Stan", "1231231",
                "123123123", testAddress1, null);

        Client savedClient = clientRepository.save(testClient1);

        Address testAddress2 = new Address("12", "13", "14",
                "15", 17, 18, 19);
//        Order order = new Order(1, LocalDate.now(), "burger", 100L);
//        List<Order> orders = new ArrayList<>();
//        orders.add(order);
        Client testClient2 = new Client( "Alla", "1111",
                "2222", testAddress2, null);
        //ClientDTO testDTO2 = clientConverter.entityToDTO(testClient2);

        mockMvc.perform(putJson("/client/update/" + savedClient.getId(), testClient2))
                .andExpect(status().isOk());
                //.andExpect(clientCheck("$",testDTO2));
    }

    public static MockHttpServletRequestBuilder putJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body);
            return put(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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

    public static ResultMatcher clientCheck(String prefix, ClientDTO client) {
        return ResultMatcher.matchAll(
                jsonPath(prefix + ".name").value(client.getName()),
                jsonPath(prefix + ".inn").value(client.getInn()),
                jsonPath(prefix + ".phoneNumber").value(client.getPhoneNumber())
        );
    }
}