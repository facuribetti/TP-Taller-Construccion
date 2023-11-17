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

    @Column(name = "dia_semana")
    private int diaSemana;

    @OneToMany(mappedBy = "planEntrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> listaEjercicios;

    public PlanEntrenamiento(){}

    public PlanEntrenamiento(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

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
                ", diaSemana=" + diaSemana +
                ", listaEjercicios=" + listaEjercicios +
                '}';
    }
}
