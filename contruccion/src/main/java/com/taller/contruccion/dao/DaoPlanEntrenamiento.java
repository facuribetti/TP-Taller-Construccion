package com.taller.contruccion.dao;

import com.taller.contruccion.entity.Cliente;
import com.taller.contruccion.entity.PlanEntrenamiento;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoPlanEntrenamiento extends JpaRepository<PlanEntrenamiento, Integer>{

}