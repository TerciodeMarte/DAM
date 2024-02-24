/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.services;

import com.cafeconpalito.tarea62.repositories.VacunaPersonaRepository;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class VacunaPersonaService {

    ApplicationContext context;
    VacunaPersonaRepository vpr;

    
    public VacunaPersonaService(ApplicationContext context) {
        this.context = context;
        vpr = context.getBean(VacunaPersonaRepository.class);
    }
}
