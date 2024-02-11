/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea61.services;

import com.cafeconpalito.tarea61.entities.Medicamento;
import com.cafeconpalito.tarea61.entities.Persona;
import com.cafeconpalito.tarea61.entities.Tratamiento;
import com.cafeconpalito.tarea61.repositories.ITratamiento;
import java.time.Instant;
import java.util.Date;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class TratamientoService {

    ApplicationContext context;
    ITratamiento tra;

    public TratamientoService(ApplicationContext context) {
        this.context = context;
        tra = context.getBean(ITratamiento.class);
    }
    /**
     * Asignar un medicamento a una persona, es decir, guardar un registro nuevo
     * en tratamiento
     * @param p
     * @param m
     */
    public void insert(Persona p, Medicamento m){
        Tratamiento t = new Tratamiento();
        
        int idmax=0;
        for (Tratamiento tb : tra.findAll()) {
            idmax=tb.getPktratamiento();
        }
        idmax+=1;
        
        t.setPktratamiento(idmax);
        t.setAkpersona(p);
        t.setAkmedicina(m);
        t.setFecha(Date.from(Instant.now()));
        tra.save(t);
    }
}
