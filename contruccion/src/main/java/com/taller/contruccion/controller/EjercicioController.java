package com.taller.contruccion.controller;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.service.ClienteService;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    private EjercicioService ejercicioService;
    private ClienteService clienteService;

    public EjercicioController(EjercicioService serviceEjercicio,
                               ClienteService serviceCliente) {
        ejercicioService = serviceEjercicio;
        clienteService = serviceCliente;
    }

    @GetMapping("/{id}")
    public String obtenerEjercicioPorId(@PathVariable int id, Model model) {

        Ejercicio ejercicio = ejercicioService.encontrarPorId(id);

        model.addAttribute("ejercicio", ejercicio);

        return "ejercicio/ejercicio/" + ejercicio.getId_ejercicio();
    }

    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio, Cliente cliente, Model model) {
        model.addAttribute("cliente", cliente);
        ejercicioService.crearEjercicio(ejercicio,clienteService.encontrarPorId(cliente.getId_cliente()).getPlanEntrenamiento());

        return "redirect:/Cliente/" + cliente.getId_cliente();
    }

}