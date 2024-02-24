/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea61.services;

import com.cafeconpalito.tarea61.entities.Laboratorio;
import com.cafeconpalito.tarea61.entities.Medicamento;
import com.cafeconpalito.tarea61.repositories.ILaboratorio;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class LaboratorioService {

    ApplicationContext context;
    ILaboratorio lab;

    public LaboratorioService(ApplicationContext context) {
        this.context = context;
        lab = context.getBean(ILaboratorio.class);
    }

    /**
     * Mostrar el nombre del laboratorio y la inversión realizada para el total
     * de medicamentos que hay en stock por cada laboratorio, ordenadas por
     * precio de menor a mayor.
     */
    public void allLaboratoriesWithStock() {
       List<Laboratorio> lista = (List<Laboratorio>) lab.allLaboratoriesWithStock();
        for (Laboratorio l : lista) {
            double aux= 0;
            for (Medicamento m : l.getMedicamentoList()) {
                aux= m.getPvp()*m.getStock();
            }
            System.out.println("ID: " + l.getNombre() + " Inversión: "+ aux);
        }
    }
}
