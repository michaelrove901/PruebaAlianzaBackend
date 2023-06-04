package com.example.pruebaGML.service.impl;
import com.example.pruebaGML.dto.ClienteDTO;
import com.example.pruebaGML.entity.Cliente;
import com.example.pruebaGML.exceptions.ClienteCreationException;
import com.example.pruebaGML.exceptions.ClienteNotFoundException;
import com.example.pruebaGML.repository.ClienteRepository;
import com.example.pruebaGML.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ClienteServiceImpl implements ClienteService {
    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        logger.info("Se consulto todos los clientes");
        return clientes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        logger.info("Consultando cliente por ID: {}", id);

        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            logger.info("Cliente encontrado: {}", cliente);
            return convertToDto(cliente);
        } else {
            String mensaje = "Cliente no encontrado para el ID: " + id;
            logger.warn(mensaje);
            throw new ClienteNotFoundException(mensaje);
        }
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        logger.info("Entro al metodo nuevo cliente: {}", clienteDTO);
        try {
            Cliente cliente = convertToEntity(clienteDTO);
            Cliente clienteCreado = clienteRepository.save(cliente);
            logger.info("Cliente creado: {}", clienteCreado);
            return convertToDto(clienteCreado);
        } catch (Exception e) {
            logger.error("Error al crear el cliente: {}", e.getMessage());
            throw new ClienteCreationException("Error al crear el cliente");
        }
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        logger.info("Actualizando cliente con ID {}: {}", id, clienteDTO);

        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setName(clienteDTO.getName());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setPhone(clienteDTO.getPhone());
            cliente.setStartDate(clienteDTO.getStartDate());
            cliente.setEndDate(clienteDTO.getEndDate());

            Cliente clienteActualizado = clienteRepository.save(cliente);
            logger.info("Cliente actualizado: {}", clienteActualizado);
            return convertToDto(clienteActualizado);
        } else {
            String mensaje = "Cliente no encontrado para el ID: " + id;
            logger.warn(mensaje);
            throw new ClienteNotFoundException(mensaje);
        }
    }

    @Override
    public void deleteCliente(Long id) {
        logger.info("Eliminando cliente con ID: {}", id);

        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            clienteRepository.delete(cliente);
            logger.info("Cliente eliminado con éxito");
        } else {
            String mensaje = "Cliente no encontrado para el ID: " + id;
            logger.warn(mensaje);
            throw new ClienteNotFoundException(mensaje);
        }
    }

    @Override
    public ClienteDTO getClienteByKey(String keyClient) {
        logger.info("Consultando cliente por keyClient: {}", keyClient);
        Optional<Cliente> optionalCliente = clienteRepository.findByKeyClient(keyClient);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            logger.info("Cliente encontrado: {}", cliente);
            return convertToDto(cliente);
        } else {
            String mensaje = "Cliente no encontrado para el keyClient: " + keyClient;
            logger.warn(mensaje);
            return null;
        }
    }
    @Override
    public List<ClienteDTO> advancedSearchClientes(String name, String email, String phone,String keyClient) {
        List<Cliente> clientes = clienteRepository.advancedSearchClientes(name, email, phone,keyClient);
        logger.info("Busqueda Avanzada: name={}, email={}, phone={}", name, email, phone);
        return clientes.stream()
                .map(cliente -> convertToDto(cliente))
                .collect(Collectors.toList());
    }
    private Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return cliente;
    }

    private ClienteDTO convertToDto(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }



}

