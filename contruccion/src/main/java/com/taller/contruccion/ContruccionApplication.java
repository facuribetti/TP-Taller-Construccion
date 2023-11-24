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
        Cliente cliente = new Cliente("perez",123,"user@user.com","juan","123");   //creo una entity cliente
        PlanEntrenamiento planEntrenamiento = new PlanEntrenamiento();                                        //creo una entity PlanEntrenamiento
        Ejercicio ejercicio = new Ejercicio("piernas","corré",9999);                     //creo una entity ejercicio
        ejercicio.setPlanEntrenamiento(planEntrenamiento);                                                              //le seteo el plan de entrenamiento al ejercicio
        cliente.setPlanEntrenamiento(planEntrenamiento);                                                                //LE SETEO EL PLAN AL CLIENTE
        Optional<Cliente> optionalCliente = Optional.ofNullable(clienteService.encontrarPorId(1));
        if(optionalCliente.isEmpty())
            clienteService.crearCliente(cliente);
        Optional<Ejercicio> optionalEjercicio = Optional.ofNullable(ejercicioService.encontrarPorId(1));
        if(optionalEjercicio.isEmpty())
            ejercicioService.crearEjercicio(ejercicio, planEntrenamiento);                                     //guardo el ejercicio que ya tiene seteado un plan de
                                                                                                                        // entrenamiento que está unido a un cliente
    }
}