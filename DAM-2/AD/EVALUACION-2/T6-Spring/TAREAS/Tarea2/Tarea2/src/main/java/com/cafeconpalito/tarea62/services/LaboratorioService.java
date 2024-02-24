/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.tarea62.services;

import com.cafeconpalito.tarea62.entities.Laboratorio;
import com.cafeconpalito.tarea62.entities.Vacuna;
import com.cafeconpalito.tarea62.repositories.LaboratorioRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author TerciodeMarte
 */
public class LaboratorioService {

    ApplicationContext context;
    LaboratorioRepository lr;

    public LaboratorioService(ApplicationContext context) {
        this.context = context;
        lr = context.getBean(LaboratorioRepository.class);
    }

    /**
     * La lista de los laboratorios.
     *
     * @return
     */
    public List<Laboratorio> findAll() {
        return lr.findAll();
    }

    /**
     * Buscar laboratorio por nombre
     *
     * @param name
     * @return
     */
    public Laboratorio findByName(String name) {
        for (Laboratorio lab : findAll()) {
            if (lab.getNombre().equalsIgnoreCase(name)) {
                return lab;
            }
        }
        return null;
    }

    /**
     *
     * Inversión realizada por laboratorio
     * @return
     */
    public List<Object[]> inversionPorLaboratorio() {

        List<Object[]> lista = new LinkedList<>();

        for (Laboratorio l : lr.findAll()) {

            double invAux = 0;
            for (Vacuna v : l.getVacunaList()) {
                invAux += v.getStock() * l.getPvpdosis();
            }

            lista.add(new Object[]{l, invAux});
        }

        return lista;
    }
}
