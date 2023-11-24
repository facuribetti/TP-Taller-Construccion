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
        List<Ejercicio> ejercicios = ejercicioService.encontrarEjerciciosPorPlanEntrenamiento(planEntrenamiento);

        model.addAttribute("cliente", cliente);
        model.addAttribute("planEntrenamiento", planEntrenamiento);
        model.addAttribute("ejercicios", ejercicios);

        return "cliente/show-client";
    }

    @GetMapping("/crearCliente")
    public String crearCliente(Model model) {
        Cliente cliente = new Cliente();

        model.addAttribute(cliente);
        return "redirect:/Cliente/guardarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        PlanEntrenamiento planEntrenamiento = new PlanEntrenamiento();
        cliente.setPlanEntrenamiento(planEntrenamiento);
        clienteService.crearCliente(cliente);

        return "redirect:/Cliente/" + cliente.getId_cliente();
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "/cliente/nuevo-cliente";
    }

}