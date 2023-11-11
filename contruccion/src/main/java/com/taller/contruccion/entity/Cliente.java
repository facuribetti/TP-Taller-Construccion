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

    @Column(name = "dni")
    private long dni;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //JoinColumn(name = "shopping_cart_id")
    //private PlanDeEntrenamiento planDeEntrenamiento;

    //@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<PlanDeEntrenamiento> planesDeEntrenamiento;

}
