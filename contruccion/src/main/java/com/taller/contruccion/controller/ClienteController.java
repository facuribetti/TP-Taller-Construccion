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

    //Devuelve la vista de un cliente con la información de sus ejercicios
    @GetMapping("/{id}")
    public String obtenerClientePorId(@PathVariable int id, Model model) {
        //se buscan los datos neceserios en la base de datos mediante el uso de los servicios
        Cliente cliente = clienteService.encontrarPorId(id);
        PlanEntrenamiento planEntrenamiento = cliente.getPlanEntrenamiento();
        List<Ejercicio> ejercicios = ejercicioService.encontrarEjerciciosPorPlanEntrenamiento(planEntrenamiento);

        //Se agregan los datos al modelo que luego sera renderizado
        model.addAttribute("cliente", cliente);
        model.addAttribute("planEntrenamiento", planEntrenamiento);
        model.addAttribute("ejercicios", ejercicios);

        //se devuelve la direccion donde se encuentra la vista que se va a mostrar
        return "cliente/show-client";
    }

    //Recibe los datos del nuevo cliente creado, los persiste y redirecciona al controlador que muestra los datos del
    //nuevo cliente recien creado
    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {

        PlanEntrenamiento planEntrenamiento = new PlanEntrenamiento();
        //Se le asigna un plan de entrenamiento al usuario antes de ser persistido
        cliente.setPlanEntrenamiento(planEntrenamiento);
        //Se persisten los datos en la base de datos
        clienteService.crearCliente(cliente);

        //Se redirecciona al controlador de cliente para mostrar el cliente recien creado
        return "redirect:/Cliente/" + cliente.getId_cliente();
    }

    //Devuelve la vista que permite crear un nuevo cliente
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        //Se crea un  objeto cliente vacio para luego poder unirlo al modelo que se va a renderizar y cargarle los datos
        Cliente cliente = new Cliente();
        //Se agregan los datos al modelo que luego sera renderizado
        model.addAttribute("cliente", cliente);
        //se devuelve la direccion donde se encuentra la vista que se va a mostrar
        return "/cliente/nuevo-cliente";
    }

}