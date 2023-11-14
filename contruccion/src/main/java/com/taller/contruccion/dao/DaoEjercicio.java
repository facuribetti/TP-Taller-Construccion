package com.taller.contruccion.dao;

import com.taller.contruccion.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoEjercicio extends JpaRepository <Ejercicio, Integer> {
}
