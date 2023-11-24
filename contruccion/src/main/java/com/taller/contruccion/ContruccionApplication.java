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
            cargarUnCliente(clienteService, ejercicioService);
        };
    }

    private void cargarUnCliente(ClienteService clienteService, EjercicioService ejercicioService) {
        //Se verifica que el cliente no exista en la base de datso antes de intentar guardarlo, asi no da error
        Optional<Cliente> optionalCliente = Optional.ofNullable(clienteService.encontrarPorId(1));
        if (optionalCliente.isEmpty()) {
            //se crean los objetos java necesarios para cargar un cliente por defecto  y poder mostrar sus datos al iniciar
            Cliente cliente = new Cliente("juan", "perez", 12345678, "user@user.com", "123");
            PlanEntrenamiento planEntrenamiento = new PlanEntrenamiento();
            Ejercicio ejercicio = new Ejercicio("piernas", "corré", 9999);
            //se setea el plan de entrenamiento al ejercicio
            ejercicio.setPlanEntrenamiento(planEntrenamiento);
            //se setea el plan de entrenamiento al cliente
            cliente.setPlanEntrenamiento(planEntrenamiento);
            //Se persisten los datos del cliente, plan de entrenamiento(mediante un cascading al estar setteado en cliente) y ejercicio en la base de datos
            clienteService.crearCliente(cliente);
            ejercicioService.crearEjercicio(ejercicio, planEntrenamiento);
        }
    }
}