package com.taller.contruccion.dao;

import com.taller.contruccion.entity.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoPlanEntrenamiento extends JpaRepository<PlanEntrenamiento, Integer>{



}
