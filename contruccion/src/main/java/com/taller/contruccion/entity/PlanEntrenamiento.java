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

    //POR AHORA DEJO LOS METODOS DE ESTA CLASE COMO PRIVATE!!!!
    private void agregarNuevoEjercicio(){
    }

    private void eliminarEjercicio(){
    }

    //ESTE RETORNA NULL POR AHORA!!!
    private String mostrarPlan(){
        return null;
    }

    //EL IDPLAN NO VA EN ESTE CONSTRUCTOR? COMO PASA EN CLIENTE
    public PlanEntrenamiento(int diaSemana, int id_plan) {
        this.diaSemana = diaSemana;
        this.id_plan = id_plan;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }
/*
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
*/
    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }
}
