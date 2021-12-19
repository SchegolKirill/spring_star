package com.schegol.sping.spring_star.dop_task.controllers;

import com.schegol.sping.spring_star.dop_task.converters.ClientConverter;
import com.schegol.sping.spring_star.dop_task.dto.ClientDTO;
import com.schegol.sping.spring_star.dop_task.entity.Client;
import com.schegol.sping.spring_star.dop_task.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @PostMapping("/addnewclient")
    public Client addNewClient(@RequestBody Client client){
        clientService.addClient(client);
        //return "Добавлен новый клиент: " + client.getName();
        return client;
    }

    @GetMapping("/getclient/{id}")
    @Transactional
    public ClientDTO getClient(@PathVariable("id") Integer id){
        return clientConverter.entityToDTO(clientService.getClient(id));
    }

//    @PutMapping("/update/{id}")
//    public String updateClient(@PathVariable("id") Integer id, @RequestBody ClientDTO dto){
//        clientService.updateClient(id, clientConverter.DTOToEntity(dto));
//        return "Клиент " + id + " успешно обновлен";
//    }

    @PutMapping("/update/{id}")
    public ClientDTO updateClient(@PathVariable("id") Integer id, @RequestBody ClientDTO dto){
        clientService.updateClient(id, clientConverter.DTOToEntity(dto));
        return clientConverter.entityToDTO(clientService.getClient(id));
    }

    @GetMapping("/getclients")
    public List<ClientDTO> getClients(){
        return clientConverter.entityToDTO(clientService.getClients());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id){
        clientService.deleteClient(id);
        return "Клиент " + id + " успешно удален";
    }
}
