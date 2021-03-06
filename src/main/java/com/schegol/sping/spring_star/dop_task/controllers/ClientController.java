package com.schegol.sping.spring_star.dop_task.controllers;

import com.schegol.sping.spring_star.dop_task.converters.ClientConverter;
import com.schegol.sping.spring_star.dop_task.dto.ClientDTO;
//import com.schegol.sping.spring_star.dop_task.dto.ResponseDTO;
import com.schegol.sping.spring_star.dop_task.entity.Client;
import com.schegol.sping.spring_star.dop_task.exception_handling.ClientException;
import com.schegol.sping.spring_star.dop_task.exception_handling.ClientExceptionVariant;
import com.schegol.sping.spring_star.dop_task.services.ClientService;
import com.schegol.sping.spring_star.main_task.exception_handling.PersonException;
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
        ClientDTO clientDTO = clientConverter.entityToDTO(clientService.getClient(id));
        return clientDTO;
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable("id") Integer id, @RequestBody ClientDTO dto){
        return clientService.updateClient(id, dto);
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
