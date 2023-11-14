package com.taller.contruccion;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.service.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContruccionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContruccionApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClienteService clienteService) {
        return runner -> {
            System.out.println("hello");
            cargarUnCliente(clienteService);
        };
    }

    private void cargarUnCliente(ClienteService clienteService) {
        Cliente cliente = new Cliente("arias",123,"user@user.com","alberto","123");
        clienteService.crearCliente(cliente);
    }
}