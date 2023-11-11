package com.taller.contruccion.dao;

import com.taller.contruccion.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCliente extends JpaRepository<Cliente, Integer> {

}