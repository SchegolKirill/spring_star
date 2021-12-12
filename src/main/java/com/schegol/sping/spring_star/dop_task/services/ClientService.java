package com.schegol.sping.spring_star.dop_task.services;

import com.schegol.sping.spring_star.dop_task.entity.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    Client getClient(Integer id);
    void updateClient(Integer id, Client client);
    List<Client> getClients();
    void deleteClient(Integer id);
}
