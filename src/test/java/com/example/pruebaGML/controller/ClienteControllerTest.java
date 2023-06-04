package com.example.pruebaGML.controller;

import com.example.pruebaGML.dto.ClienteDTO;
import com.example.pruebaGML.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {
    @Mock
    ClienteService clienteService;

    @InjectMocks
    ClienteController clienteController;

    @Test
    void getAllClientes() {
    }

    @Test
    void getClienteById() {

        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(1L);
        cliente.setKeyClient("abc123");
        cliente.setName("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setPhone("123456789");

        when(clienteService.getClienteById(1L)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.getClienteById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("abc123", response.getBody().getKeyClient());
        assertEquals("John Doe", response.getBody().getName());
        assertEquals("johndoe@example.com", response.getBody().getEmail());
        assertEquals("123456789", response.getBody().getPhone());
    }

    @Test
    void createCliente() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(1L);
        cliente.setKeyClient("abc123");
        cliente.setName("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setPhone("123456789");

        when(clienteService.getClienteById(1L)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.createCliente(cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("abc123", response.getBody().getKeyClient());
        assertEquals("John Doe", response.getBody().getName());
        assertEquals("johndoe@example.com", response.getBody().getEmail());
        assertEquals("123456789", response.getBody().getPhone());
    }

    @Test
    void updateCliente() {
    }

    @Test
    void deleteCliente() {
    }

    @Test
    void getClienteByKey() {

        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(1L);
        cliente.setKeyClient("abc123");
        cliente.setName("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setPhone("123456789");

        when(clienteService.getClienteById(1L)).thenReturn(cliente);

        ResponseEntity<ClienteDTO> response = clienteController.getClienteById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("abc1234", response.getBody().getKeyClient());
        assertEquals("John Doe", response.getBody().getName());
        assertEquals("johndoe@example.com", response.getBody().getEmail());
        assertEquals("123456789", response.getBody().getPhone());
    }

    @Test
    void advancedSearchClientes() {
    }
}