package com.schegol.sping.spring_star.dop_task.services;

import com.schegol.sping.spring_star.dop_task.converters.AddressConverter;
import com.schegol.sping.spring_star.dop_task.dto.ClientDTO;
//import com.schegol.sping.spring_star.dop_task.exception.ExceptionType;
import com.schegol.sping.spring_star.dop_task.entity.Client;
//import com.schegol.sping.spring_star.dop_task.exception.StarException;
import com.schegol.sping.spring_star.dop_task.exception_handling.ClientException;
import com.schegol.sping.spring_star.dop_task.exception_handling.ClientExceptionVariant;
import com.schegol.sping.spring_star.dop_task.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private  final AddressConverter addressConverter;

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new ClientException(ClientExceptionVariant.NOT_FOUND));
    }

      @Override
    public Client updateClient(Integer id, ClientDTO dto) {
        Client client = clientRepository.findById(id).orElseThrow(() ->
                new ClientException(ClientExceptionVariant.NOT_FOUND));
        client.setAddress(addressConverter.DTOToEntity(dto.getAddressDTO()));
        client.setInn(dto.getInn());
        client.setName(dto.getName());
        client.setPhoneNumber(dto.getPhoneNumber());
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.findById(id).orElseThrow(() ->
                new ClientException(ClientExceptionVariant.NOT_FOUND));
        clientRepository.deleteById(id);
    }
}
