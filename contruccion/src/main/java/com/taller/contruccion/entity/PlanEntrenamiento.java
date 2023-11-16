package com.taller.contruccion.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plan_entrenamiento")

public class PlanEntrenamiento {

    //ESTO NO FORMA PARTE DE LOS ATRIBUTOS DEL PLAN DE ENTRENAMIENTO, LO DEJO IGUAL?
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
*/

    @Column(name = "dia_semana")
    private int diaSemana;

    //@Column(name = "ejercicio")
    @OneToMany(mappedBy = "planEntrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> listaEjercicios;

    // ESTE ID PLAN NO DEBERIA SER COMO EL @ID QUE HAY EN LA CLASE CLIENTE?
    //NO ES UNA CLAVE PRIMARIA EN LA BD?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private int id_plan;

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
        //this.ejercicio = ejercicio;
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
