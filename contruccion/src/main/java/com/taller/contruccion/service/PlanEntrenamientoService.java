package com.taller.contruccion.service;

import com.taller.contruccion.dao.DaoPlanEntrenamiento;
import com.taller.contruccion.entity.PlanEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanEntrenamientoService {

    private DaoPlanEntrenamiento daoPlanEntrenamiento;

    @Autowired
    public PlanEntrenamientoService(DaoPlanEntrenamiento planEntrenamientoDAO) {
        daoPlanEntrenamiento = planEntrenamientoDAO;
    }

    public PlanEntrenamiento encontrarPorId(int id) {
        Optional<PlanEntrenamiento> resultado = daoPlanEntrenamiento.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        } else return null;
    }
}