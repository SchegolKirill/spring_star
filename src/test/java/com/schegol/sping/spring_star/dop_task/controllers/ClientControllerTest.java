package com.schegol.sping.spring_star.dop_task.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schegol.sping.spring_star.dop_task.converters.ClientConverter;
import com.schegol.sping.spring_star.dop_task.dto.AddressDTO;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        Address address = new Address("2", "3", "4",
                "5", 7, 8, 9);

        Client client = new Client("Kirill", "1231231",
                "123123123", address, null);

        mockMvc.perform(postJson("/client/addnewclient", client))
                .andExpect(status().isOk());


    }

    @Test
    void getClient() throws Exception {

        Address testAddress1 = new Address("2", "3", "4",
                "5", 7, 8, 9);
        Order order1 = new Order(null, null, null, null);
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);

        Client testClient1 = new Client("Stan", "1231231",
                "123123123", testAddress1, orders1);
        Client savedClient1 = clientRepository.save(testClient1);
        mockMvc.perform(get("/client/getclient/" + savedClient1.getId()))
                .andExpect(status().isOk())
                .andExpect(clientCheck("$", clientController.getClient(savedClient1.getId())));
    }

    @Test
    void successUpdateClient() throws Exception {
        Address address = new Address("1", "2", "3",
                "4", 17, 18, 19);
        Order order = new Order(1, null, "burger", 100L);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        Client currentClient = new Client("Alla", "1111",
                "2222", address, orders);
        Client savedClient = clientRepository.save(currentClient);

        AddressDTO addressDTO = new AddressDTO("111", "222", "333", "444",
                1700, 1800, 1900);
        ClientDTO clientDTO = new ClientDTO("name", "inn", "7900123456", addressDTO);

        mockMvc.perform(putJson("/client/update/" + savedClient.getId(), clientDTO))
                .andExpect(status().isOk());

        Optional<Client> checkClient = clientRepository.findById(savedClient.getId());
        if (checkClient.isPresent()) {
            assert checkClient.get().getInn().equals(clientDTO.getInn());
            assert checkClient.get().getName().equals(clientDTO.getName());
            assert checkClient.get().getPhoneNumber().equals(clientDTO.getPhoneNumber());
        }
    }

    @Test
    void getClients() throws Exception {
        Address testAddress1 = new Address("2", "3", "4",
                "5", 7, 8, 9);
        Order order1 = new Order(null, null, null, null);
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);

        Address testAddress2 = new Address("2", "3", "4",
                "5", 7, 8, 9);
        Order order2 = new Order(null, null, null, null);
        List<Order> orders2 = new ArrayList<>();
        orders2.add(order2);

        Address testAddress3 = new Address("2", "3", "4",
                "5", 7, 8, 9);
        Order order3 = new Order(null, null, null, null);
        List<Order> orders3 = new ArrayList<>();
        orders3.add(order3);

        Client testClient1 = new Client("Stan", "1231231",
                "123123123", testAddress1, orders1);
        Client savedClient1 = clientRepository.save(testClient1);
        Client testClient2 = new Client("Kyle", "1231231",
                "123123123", testAddress2, orders2);
        Client savedClient2 = clientRepository.save(testClient2);
        Client testClient3 = new Client("Erick", "1231231",
                "123123123", testAddress3, orders3);
        Client savedClient3 = clientRepository.save(testClient3);

        mockMvc.perform(get("/client/getclients"))
                .andExpect(status().isOk());
//                .andExpect(clientCheck("$", clientConverter.entityToDTO(savedClient1)))
//                .andExpect(clientCheck("$", clientConverter.entityToDTO(savedClient2)))
//                .andExpect(clientCheck("$", clientConverter.entityToDTO(savedClient3)));
    }

    @Test
    void deleteClient() {
    }

    public static MockHttpServletRequestBuilder putJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body);
            return put(uri)
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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