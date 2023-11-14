package com.taller.contruccion.controller;


import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService serviceCliente) {clienteService = serviceCliente;}

    @GetMapping("/{id}")
    public String obtenerClientePorId(@PathVariable int id, Model model) {

        Cliente cliente = clienteService.encontrarPorId(id);
        System.out.println(cliente);

        model.addAttribute("cliente", cliente);
        //return clienteService.encontrarPorId(id);

        return "cliente/show-client";
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.crearCliente(cliente);

        return "redirect:/Cliente" + cliente.getId();
    }

}