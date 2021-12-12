package com.schegol.sping.spring_star.dop_task.services;

import com.schegol.sping.spring_star.dop_task.entity.Client;
import com.schegol.sping.spring_star.dop_task.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void updateClient(Integer id, Client client) {
        clientRepository.findById(id).get().setAddress(client.getAddress());
        clientRepository.findById(id).get().setInn(client.getInn());
        clientRepository.findById(id).get().setName(client.getName());
        clientRepository.findById(id).get().setPhoneNumber(client.getPhoneNumber());
        clientRepository.findById(id).get().setOrders(client.getOrders());
    }

    @Override
    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
