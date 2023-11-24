package com.taller.contruccion.controller;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import com.taller.contruccion.service.ClienteService;
import com.taller.contruccion.service.EjercicioService;
import com.taller.contruccion.service.PlanEntrenamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    private EjercicioService ejercicioService;
    private ClienteService clienteService;
    private PlanEntrenamientoService planEntrenamientoService;

    public EjercicioController(EjercicioService serviceEjercicio,
                               ClienteService serviceCliente,
                               PlanEntrenamientoService servicePlan) {
        ejercicioService = serviceEjercicio;
        clienteService = serviceCliente;
        planEntrenamientoService = servicePlan;
    }

    @GetMapping("/{id}")
    public String obtenerEjercicioPorId(@PathVariable int id, Model model) {

        Ejercicio ejercicio = ejercicioService.encontrarPorId(id);

        model.addAttribute("ejercicio", ejercicio);
        //return clienteService.encontrarPorId(id);

        return "ejercicio/ejercicio/" + ejercicio.getId_ejercicio();
    }

    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio, Cliente cliente, Model model) {
        model.addAttribute("cliente", cliente);
        ejercicioService.crearEjercicio(ejercicio, cliente, clienteService.encontrarPorId(cliente.getId_cliente()).getPlanEntrenamiento());

        return "redirect:/Cliente/" + cliente.getId_cliente();
    }
/*
    @GetMapping("/nuevoEjercicio")
    public String redireccionarANuevoEjercicio(Model model, PlanEntrenamiento planEntrenamiento) {
        Ejercicio ejercicio = new Ejercicio();
        PlanEntrenamiento planEntrenamiento = ejercicioService.encontrarPlanEntrenamiento(ejercicio);
        model.addAttribute("ejercicio", ejercicio);
        return "/ejercicio/nuevo-ejercicio";
    }
 */

}