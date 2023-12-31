package com.taller.contruccion.service;

import com.taller.contruccion.dao.DaoEjercicio;
import com.taller.contruccion.dao.DaoPlanEntrenamiento;
import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {

    private DaoEjercicio daoEjercicio;

    @Autowired
    public EjercicioService(DaoEjercicio ejercicioDao) {
        daoEjercicio = ejercicioDao;
    }

    public List<Ejercicio> encontrarEjerciciosPorPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        Optional<List<Ejercicio>> resultado = Optional.ofNullable(daoEjercicio.findByPlanEntrenamiento(planEntrenamiento));
        if (resultado.isPresent()) {
            return resultado.get();
        } else return null;
    }

    public void crearEjercicio(Ejercicio ejercicio, PlanEntrenamiento planEntrenamiento) {
            ejercicio.setPlanEntrenamiento(planEntrenamiento);
            daoEjercicio.save(ejercicio);
    }
}