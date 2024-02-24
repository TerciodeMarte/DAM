/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea62.services;

import com.cafeconpalito.tarea62.entities.Laboratorio;
import com.cafeconpalito.tarea62.entities.Persona;
import com.cafeconpalito.tarea62.repositories.PersonaRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class PersonaService {

    ApplicationContext context;
    PersonaRepository pr;

    public PersonaService(ApplicationContext context) {
        this.context = context;
        pr = context.getBean(PersonaRepository.class);
    }

    /**
     * Lista con los datos de personas que han recibido un número determinado de
     * dosis
     *
     * @param ndosis
     * @return
     */
    public List<Persona> personasConNdosis(int ndosis) {
        List<Persona> lista = new LinkedList<>();
        for (Persona p : pr.findAll()) {
            if (p.getNdosis() == ndosis) {
                lista.add(p);
            }
        }
        return lista;
    }

    /**
     * Lista de personas que han sido vacunadas con dosis de un laboratorio
     * determinado
     *
     * @param laboratorio
     * @return
     */
    public List<Persona> personasConVacunaLaboratorio(Laboratorio laboratorio) {
        return pr.findByVacunaLaboratorio(laboratorio);
    }

    /**
     * Lista de personas que han sido vacunadas con dosis de un laboratorio
     * determinado pero con nombre
     *
     * @param laboratorio
     * @return
     */
    public List<Persona> personasConVacunaLaboratorio(String laboratorio) {
        return pr.findByVacunaLabName(laboratorio);
    }

    /**
     * Añadir una persona
     *
     * @param persona
     * @return la persona recién incorporada a la base de datos
     */
    public Persona addPersona(Persona persona) {
        return pr.save(persona);
    }

}
