package com.taller.contruccion.controller;


import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/crearCliente")
    public String crearCliente(Model model){
        Cliente cliente = new Cliente();

        model.addAttribute(cliente);
        return "cliente/nuevo-cliente";

    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        System.out.println(cliente);
        clienteService.crearCliente(cliente);

        return "redirect:/Cliente/" + cliente.getId_cliente();
    }

}