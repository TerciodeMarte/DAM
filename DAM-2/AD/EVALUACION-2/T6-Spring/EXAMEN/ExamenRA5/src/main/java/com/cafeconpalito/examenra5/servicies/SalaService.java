/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.servicies;

import com.cafeconpalito.examenra5.entities.Pelicula;
import com.cafeconpalito.examenra5.entities.Proyeccion;
import com.cafeconpalito.examenra5.entities.Sala;
import com.cafeconpalito.examenra5.repositories.PeliculaRepository;
import com.cafeconpalito.examenra5.repositories.SalaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class SalaService {

    ApplicationContext context;
    SalaRepository sr;

    public SalaService(ApplicationContext context) {
        this.context = context;
        sr = context.getBean(SalaRepository.class);
    }

    public List<Object[]> getNumPeli() {
        List<Sala> list=sr.findAll();
        List<Object[]> retorno= new ArrayList<>();
        for (Sala sala : list) {
            Object[] r= new Object[3];
            int cont=0;
            for (Proyeccion p : sala.getProyeccionList()) {
                cont++;

            }
            r[0]=sala.getPksala();
            r[1]=sala.getNombre();
            r[2]=cont;
            retorno.add(r);
            cont=0;  
        }
       
        return retorno;
    }
    
    
}
