/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.servicies;

import com.cafeconpalito.examenra5.entities.Entrada;
import com.cafeconpalito.examenra5.entities.Pelicula;
import com.cafeconpalito.examenra5.entities.Proyeccion;
import com.cafeconpalito.examenra5.entities.Socio;
import com.cafeconpalito.examenra5.repositories.EntradaRepository;
import com.cafeconpalito.examenra5.repositories.SalaRepository;
import com.cafeconpalito.examenra5.repositories.SocioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntradaService {

    ApplicationContext context;
    EntradaRepository er;
    SocioRepository sr;

    public EntradaService(ApplicationContext context) {
        this.context = context;
        er = context.getBean(EntradaRepository.class);
        sr =context.getBean(SocioRepository.class);
    }

    public Entrada insert(int idsocio,int idproyeccion,int numentradas) {
        Entrada e= new Entrada();
        boolean control=false;
        
        for (Entrada en : er.findAll()) {
            if (en.getFksocio().getPksocio()==idsocio && en.getFkproyeccion().getPkproyeccion()==idproyeccion) {
                control=true;
            }else{
                if (en.getFkproyeccion().getNumentradas()+numentradas>=en.getFkproyeccion().getFksala().getAforo()) {
                    control=true;
                }

            }
        }
        if (!control) {
            e.setFksocio(new Socio(idsocio,sr.findById(idsocio).get().getNombre()));
            e.setFkproyeccion(new Proyeccion(idproyeccion));
        }
        return er.save(e);
    }
    
    
}
