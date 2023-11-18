package com.taller.contruccion.controller;

import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    private EjercicioService ejercicioService;

    public EjercicioController(EjercicioService serviceEjercicio) {
        ejercicioService = serviceEjercicio;
    }

    @GetMapping("/{id}")
    public String obtenerEjercicioPorId(@PathVariable int id, Model model) {

        Ejercicio ejercicio = ejercicioService.encontrarPorId(id);
        System.out.println(ejercicio);

        model.addAttribute("ejercicio", ejercicio);
        //return clienteService.encontrarPorId(id);

        return "ejercicio/ejercicio/" + ejercicio.getId_ejercicio();
    }

    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio) {
        ejercicioService.crearEjercicio(ejercicio);

        return "redirect:/ejercicio/" + ejercicio.getId_ejercicio();
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