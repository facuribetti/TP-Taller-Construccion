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
    private DaoPlanEntrenamiento daoPlanEntrenamiento;

    @Autowired
    public EjercicioService(DaoEjercicio ejercicioDao, DaoPlanEntrenamiento planEntrenamientoDao) {
        daoEjercicio = ejercicioDao;
        daoPlanEntrenamiento = planEntrenamientoDao;
    }

    public Ejercicio encontrarPorId(int id) {
        Optional<Ejercicio> resultado = daoEjercicio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else return null;
    }

    public PlanEntrenamiento encontrarPlanEntrenamiento (Ejercicio ejercicio) {
        Optional<PlanEntrenamiento> planEntrenamiento = daoPlanEntrenamiento.findById(ejercicio.getPlanEntrenamiento().getId_plan());
        if (planEntrenamiento.isPresent()){
            return planEntrenamiento.get();
        } else return null;
    }

    public List<Ejercicio> encontrarEjerciciosPorPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        Optional<List<Ejercicio>> resultado = Optional.ofNullable(daoEjercicio.findByPlanEntrenamiento(planEntrenamiento));
        if (resultado.isPresent()) {
            return resultado.get();
        } else return null;
    }


    public void crearEjercicio(Ejercicio ejercicio, Cliente cliente, PlanEntrenamiento planEntrenamiento) {
        //Optional<PlanEntrenamiento> planEntrenamiento = daoPlanEntrenamiento.findById(ejercicio.getPlanEntrenamiento().getId_plan());
        //if (planEntrenamiento.isPresent()) {
            //ejercicio.setPlanEntrenamiento(planEntrenamiento.get());
            ejercicio.setPlanEntrenamiento(planEntrenamiento);
            daoEjercicio.save(ejercicio);
        //}
    }

}