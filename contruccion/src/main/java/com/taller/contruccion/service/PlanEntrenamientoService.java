package com.taller.contruccion.service;


import com.taller.contruccion.dao.DaoPlanEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanEntrenamientoService {

        private DaoPlanEntrenamiento planEntrenamientoDao;

        @Autowired
        public PlanEntrenamientoService(DaoPlanEntrenamiento planEntrenamientoDAO) {planEntrenamientoDao = planEntrenamientoDAO;}


}
