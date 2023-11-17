package com.taller.contruccion.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_cliente;

    @Column(name = "apellido")
    private String apellido;

    //PORQUE ESTE NO ES UNIQUE TAMBIEN? A QUE SE REFIERE CON UNIQUE?
    @Column(name = "dni")
    private long dni;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasenia")
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_plan")
    private PlanEntrenamiento planEntrenamiento;

    //@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<PlanDeEntrenamiento> planesDeEntrenamiento;
    public Cliente(){}

    public Cliente(String apellido, long dni, String email, String nombre, String contrasenia) {
        //El id no va en el constructor porque sino explota todo
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public PlanEntrenamiento getPlanEntrenamiento() {
        return planEntrenamiento;
    }

    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id_cliente +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + contrasenia + '\'' +
                '}';
    }
}
