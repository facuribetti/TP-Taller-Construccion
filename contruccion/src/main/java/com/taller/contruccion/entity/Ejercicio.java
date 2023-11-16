package com.taller.contruccion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private int id_ejercicio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cant_repeticiones")
    private int cantRepeticiones;

    @ManyToOne
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;


    public Ejercicio() {}

    public Ejercicio(String nombre, String descripcion, int cantRepeticiones, PlanEntrenamiento planEntrenamiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantRepeticiones = cantRepeticiones;
        this.planEntrenamiento = planEntrenamiento;
    }

    public int getCantRepeticiones() {
        return cantRepeticiones;
    }

    public void setCantRepeticiones(int cantRepeticiones) {
        this.cantRepeticiones = cantRepeticiones;
    }

    public int getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PlanEntrenamiento getPlanEntrenamiento() {
        return planEntrenamiento;
    }

    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }
}
