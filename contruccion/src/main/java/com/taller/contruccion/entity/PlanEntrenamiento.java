package com.taller.contruccion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plan_entrenamiento")

public class PlanEntrenamiento {

    //ESTO NO FORMA PARTE DE LOS ATRIBUTOS DEL PLAN DE ENTRENAMIENTO, LO DEJO IGUAL?

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cant_repeticiones")
    private int cantRepeticiones;

    @Column(name = "dia_semana")
    private int diaSemana;

    @Column(name = "ejercicio")
    private Ejercicio ejercicio;

    // ESTE ID PLAN NO DEBERIA SER COMO EL @ID QUE HAY EN LA CLASE CLIENTE?
    //NO ES UNA CLAVE PRIMARIA EN LA BD?
    @Column(name = "id_plan")
    private int idPlan;

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
    public PlanEntrenamiento(int cantRepeticiones, int diaSemana, Ejercicio ejercicio, int idPlan) {
        this.cantRepeticiones = cantRepeticiones;
        this.diaSemana = diaSemana;
        this.ejercicio = ejercicio;
        this.idPlan = idPlan;
    }

    public int getCantRepeticiones() {
        return cantRepeticiones;
    }

    public void setCantRepeticiones(int cantRepeticiones) {
        this.cantRepeticiones = cantRepeticiones;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }
}
