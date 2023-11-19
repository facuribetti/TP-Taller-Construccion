package com.taller.contruccion.controller;


import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import com.taller.contruccion.service.ClienteService;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {

    private ClienteService clienteService;
    private EjercicioService ejercicioService;

    public ClienteController(ClienteService serviceCliente, EjercicioService serviceEjercicio) {
        clienteService = serviceCliente;
        ejercicioService = serviceEjercicio;
    }

    @GetMapping("/{id}")
    public String obtenerClientePorId(@PathVariable int id, Model model) {

        Cliente cliente = clienteService.encontrarPorId(id);
        PlanEntrenamiento planEntrenamiento = cliente.getPlanEntrenamiento();
        List<Ejercicio> ejercicios = ejercicioService.encontrarPorPlanEntrenamiento(planEntrenamiento);
        //System.out.println(cliente.getPlanEntrenamiento());
        System.out.println(cliente);
        System.out.println(ejercicios);

        model.addAttribute("cliente", cliente);
        model.addAttribute("planEntrenamiento", planEntrenamiento);
        model.addAttribute("ejercicios", ejercicios);
        //return clienteService.encontrarPorId(id);

        return "cliente/show-client";
    }

    @GetMapping("/crearCliente")
    public String crearCliente(Model model) {
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