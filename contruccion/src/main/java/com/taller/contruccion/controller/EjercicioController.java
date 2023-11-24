package com.taller.contruccion.controller;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.service.ClienteService;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.stereotype.Controller;
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
    //Recibe los datos del nuevo ejercicio creado, lo persiste y redirecciona al controlador que muestra los datos del
    //plan de entrenamiento que contiene la lista de ejercicios y la vista web de la misma
    @PostMapping("/crearEjercicio")
    public String crearEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio, Cliente cliente) {

        ejercicioService.crearEjercicio(ejercicio, clienteService.encontrarPorId(cliente.getId_cliente()).getPlanEntrenamiento());

        //Se redirecciona al controlador de planEntrenamiento para mostrar la lista de ejercicios del cliente
        return "redirect:/planEntrenamiento/" + cliente.getId_cliente();
    }
}