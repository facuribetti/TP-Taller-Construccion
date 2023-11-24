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

import java.util.List;


@Controller
@RequestMapping("/planEntrenamiento")
public class PlanEntrenamientoController {
    private PlanEntrenamientoService planEntrenamientoService;
    private EjercicioService ejercicioService;
    private ClienteService clienteService;

    public PlanEntrenamientoController(PlanEntrenamientoService servicePlan,
                                       EjercicioService serviceEjercicio,
                                       ClienteService serviceCliente) {
        planEntrenamientoService = servicePlan;
        ejercicioService = serviceEjercicio;
        clienteService = serviceCliente;
    }

    //Devuelve la vista que contiene todos los ejercicios de un cliente dado por el id enviado en el path de la url
    @GetMapping("/{id}")
    public String obtenerEjerciciosPorIdPlan(@PathVariable String id, Model model) {
        //se buscan los datos neceserios en la base de datos mediante el uso de los servicios
        Cliente cliente = clienteService.encontrarPorId(Integer.parseInt(id));
        PlanEntrenamiento planEntrenamiento = planEntrenamientoService.encontrarPorId(Integer.parseInt(id));
        List<Ejercicio> ejercicios = ejercicioService.encontrarEjerciciosPorPlanEntrenamiento(planEntrenamiento);

        //Se agregan los datos al modelo que luego sera renderizado
        model.addAttribute("cliente", cliente);
        model.addAttribute("ejercicios", ejercicios);

        //se devuelve la direccion donde se encuentra la vista que se va a mostrar
        return "ejercicio/lista-ejercicios";
    }
}