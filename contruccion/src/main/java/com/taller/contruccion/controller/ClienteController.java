package com.taller.contruccion.controller;


import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService serviceCliente) {clienteService = serviceCliente;}

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {
        return clienteService.encontrarPorId(id);
    }

    @PostMapping("/crearCliente")
    public void crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
    }

}