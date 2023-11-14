package com.taller.contruccion.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "apellido")
    private String apellido;

    //PORQUE ESTE NO ES UNIQUE TAMBIEN? A QUE SE REFIERE CON UNIQUE?
    @Column(name = "dni")
    private long dni;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;

    //@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<PlanDeEntrenamiento> planesDeEntrenamiento;
    public Cliente(){}

    public Cliente(String apellido, long dni, String email, String nombre, String password) {
        //El id no va en el constructor porque sino explota todo
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
