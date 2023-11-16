package com.taller.contruccion.service;


import com.taller.contruccion.dao.DaoEjercicio;
import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import org.springframework.beans.factory.annotation.Autowired;

public class EjercicioService {

    private DaoEjercicio daoEjercicio;

    @Autowired
    public EjercicioService(DaoEjercicio ejercicioDao) {
        daoEjercicio = ejercicioDao;
    }

    public void crearEjercicio(Ejercicio ejercicio) {
        daoEjercicio.save(ejercicio);
    }

}


