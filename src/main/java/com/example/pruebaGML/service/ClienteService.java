package com.example.pruebaGML.service;

import com.example.pruebaGML.dto.ClienteDTO;

import java.util.List;



public interface ClienteService {

    List<ClienteDTO> getAllClientes();

    ClienteDTO getClienteById(Long id);

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    void deleteCliente(Long id);

    ClienteDTO getClienteByKey(String keyClient);

    List<ClienteDTO> advancedSearchClientes(String name, String email, String phone, String keyClient);
}