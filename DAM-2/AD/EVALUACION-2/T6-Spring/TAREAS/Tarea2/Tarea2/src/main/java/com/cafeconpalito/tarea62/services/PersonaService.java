/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.services;

import com.cafeconpalito.tarea62.repositories.PersonaRepository;
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

}
