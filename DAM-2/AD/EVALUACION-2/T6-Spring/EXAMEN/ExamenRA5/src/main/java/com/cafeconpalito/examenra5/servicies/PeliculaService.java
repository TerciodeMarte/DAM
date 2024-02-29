/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.servicies;

import com.cafeconpalito.examenra5.entities.Pelicula;
import com.cafeconpalito.examenra5.entities.Proyeccion;
import com.cafeconpalito.examenra5.repositories.PeliculaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class PeliculaService {

    ApplicationContext context;
    PeliculaRepository pr;

    public PeliculaService(ApplicationContext context) {
        this.context = context;
        pr = context.getBean(PeliculaRepository.class);
    }

    public List<Pelicula> findBySala(int idsala) {
        List<Pelicula> list=pr.findAll();
        List<Pelicula> retorno= new ArrayList<>();
        for (Pelicula pelicula : list) {
            for (Proyeccion proyeccion : pelicula.getProyeccionList()) {
                if (proyeccion.getFksala().getPksala()==idsala) {
                    retorno.add(pelicula);
                }

            }
        }
        return retorno;
    }
    
    
}
