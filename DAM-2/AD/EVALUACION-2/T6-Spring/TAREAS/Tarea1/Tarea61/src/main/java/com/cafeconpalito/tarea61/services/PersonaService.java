/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea61.services;

import com.cafeconpalito.tarea61.entities.Persona;
import com.cafeconpalito.tarea61.entities.Tratamiento;
import com.cafeconpalito.tarea61.repositories.IPersona;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class PersonaService {

    ApplicationContext context;
    IPersona repo;

    public PersonaService(ApplicationContext context) {
        this.context = context;
        repo = context.getBean(IPersona.class);
    }
    /**
     * Mostrar los datos de una persona a partir de su identificador
     * @param id 
     * @return  
     */
    public Persona findById(int id){
        Persona p = repo.findById(id).orElse(null);
        if (p!= null) {
            System.out.println("ID: "+p.getPkpersona() + " NOMBRE: "+ p.getNombre() + " FECHA NAC: " + p.getFechanacimiento().toString());
        }
        return p;
    }
    /**
     * Mostrar todos los datos de las personas que están recibiendo un tratamiento
     */
    public void findAllWithTreatment(){
        List<Persona> lista = (List<Persona>) repo.findAll();
        for (Persona p : lista) {
            if (!p.getTratamientoList().isEmpty()) {
                System.out.println("ID: "+p.getPkpersona() + " NOMBRE: "+ p.getNombre() + " FECHA NAC: " +p.getFechanacimiento().toString());
            }
             
        }
    }
}
