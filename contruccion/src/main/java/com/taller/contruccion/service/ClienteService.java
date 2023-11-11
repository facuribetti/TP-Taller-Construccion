package com.taller.contruccion.service;

import com.taller.contruccion.dao.DaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private DaoCliente daoCliente;

    @Autowired
    public ClienteService(DaoCliente clienteDao) {daoCliente = clienteDao;}

}