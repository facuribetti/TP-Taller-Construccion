package com.taller.contruccion.dao;

import com.taller.contruccion.entity.Ejercicio;
import com.taller.contruccion.entity.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoEjercicio extends JpaRepository <Ejercicio, Integer> {

    List<Ejercicio> findByPlanEntrenamiento(PlanEntrenamiento planEntrenamiento);

}
