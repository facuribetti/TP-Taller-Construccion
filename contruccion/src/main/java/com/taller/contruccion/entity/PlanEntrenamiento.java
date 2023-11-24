package com.taller.contruccion.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plan_entrenamiento")

public class PlanEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private int id_plan;

    @OneToMany(mappedBy = "planEntrenamiento", cascade = CascadeType.ALL)
    private List<Ejercicio> listaEjercicios;

    public PlanEntrenamiento(){}

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    @Override
    public String toString() {
        return "PlanEntrenamiento{" +
                "id_plan=" + id_plan +
                ", listaEjercicios=" + listaEjercicios +
                '}';
    }
}