package com.cafeconpalito.tarea61.services;

import com.cafeconpalito.tarea61.entities.Medicamento;
import com.cafeconpalito.tarea61.entities.Persona;
import com.cafeconpalito.tarea61.entities.Tratamiento;
import com.cafeconpalito.tarea61.repositories.IMedicamento;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MedicamentoService {

    ApplicationContext context;
    IMedicamento med;
    PersonaService ps;

    public MedicamentoService(ApplicationContext context) {
        this.context = context;
        med = context.getBean(IMedicamento.class);
        ps = new PersonaService(context);
    }

    /**
     * Mostrar los datos de todos los medicamentos.
     */
    public void allMedicamentos() {
        List<Medicamento> lista = (List<Medicamento>) med.findAll();
        for (Medicamento m : lista) {
            System.out.println("ID: " + m.getPkmedicamento() + "- Formato:" + m.getFormato() + "- Stock: " + m.getStock() + "- PVP: " + m.getPvp() + "- Laboratorio: " + m.getAklaboratorio().getNombre());
        }
    }
    
    public Medicamento findById(int id){
        return med.findById(id).orElse(null);
    }

    /**
     * Mostrar los datos de los medicamentos con los que se está tratando a una
     * persona determinada.
     *
     * @param id
     */
    public void findByPerson(int id) {
        Persona p = ps.findById(id);
        if (p != null) {
            for (Tratamiento t : p.getTratamientoList()) {
               Medicamento m= t.getAkmedicina();
               System.out.println("ID: " + m.getPkmedicamento() + "- Formato:" + m.getFormato() + "- Stock: " + m.getStock() + "- PVP: " + m.getPvp() + "- Laboratorio: " + m.getAklaboratorio().getNombre());

            }
        }
    }
}
