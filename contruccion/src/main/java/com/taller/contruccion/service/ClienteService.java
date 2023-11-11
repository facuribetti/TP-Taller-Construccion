package com.taller.contruccion.service;

import com.taller.contruccion.dao.DaoCliente;
import com.taller.contruccion.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private DaoCliente daoCliente;

    @Autowired
    public ClienteService(DaoCliente clienteDao) {
        daoCliente = clienteDao;
    }

    public Cliente encontrarPorId(int id) {
        Optional<Cliente> resultado = daoCliente.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        } else return null;
    }

    public void crearCliente(Cliente cliente) {
        daoCliente.save(cliente);
    }
}