/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.services;

import com.cafeconpalito.tarea62.repositories.VacunaRepository;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class VacunaService {

    ApplicationContext context;
    VacunaRepository vr;

    
    public VacunaService(ApplicationContext context) {
        this.context = context;
        vr = context.getBean(VacunaRepository.class);
    }
}
