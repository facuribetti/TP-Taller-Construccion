package com.taller.contruccion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;

    public Ejercicio() {

    }
}
