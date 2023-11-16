package com.taller.contruccion.controller;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EjercicioController {

        private EjercicioService ejercicioService;
/*
        public EjercicioController(EjercicioService serviceEjercicio) {ejercicioService = serviceEjercicio;}

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
*/
    }

