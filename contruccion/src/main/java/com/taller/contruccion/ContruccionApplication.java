package com.taller.contruccion;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import com.taller.contruccion.service.ClienteService;
import com.taller.contruccion.service.EjercicioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ContruccionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContruccionApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClienteService clienteService, EjercicioService ejercicioService) {
        return runner -> {
            System.out.println("hello");
            cargarUnCliente(clienteService, ejercicioService);
        };
    }

    private void cargarUnCliente(ClienteService clienteService, EjercicioService ejercicioService) {
        Cliente cliente = new Cliente("arias",123,"user@user.com","alberto","123");
        PlanEntrenamiento planEntrenamiento = new PlanEntrenamiento(1);
        Ejercicio ejercicio = new Ejercicio("a","a",1);
        ejercicio.setPlanEntrenamiento(planEntrenamiento);
        cliente.setPlanEntrenamiento(planEntrenamiento);
        Optional<Cliente> optionalCliente = Optional.ofNullable(clienteService.encontrarPorId(1));
        if(optionalCliente.isEmpty())
            clienteService.crearCliente(cliente);
        Optional<Ejercicio> optionalEjercicio = Optional.ofNullable(ejercicioService.encontrarPorId(1));
        if(optionalEjercicio.isEmpty())
            ejercicioService.crearEjercicio(ejercicio);
    }
}