package com.cafeconpalito.tarea61;

import com.cafeconpalito.tarea61.services.LaboratorioService;
import com.cafeconpalito.tarea61.services.MedicamentoService;
import com.cafeconpalito.tarea61.services.PersonaService;
import com.cafeconpalito.tarea61.services.TratamientoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        MedicamentoService ms = new MedicamentoService(context);
        PersonaService ps = new PersonaService(context);
        LaboratorioService ls = new LaboratorioService(context);
        TratamientoService ts = new TratamientoService(context);

        System.out.println("CONSULTA 1");
        ms.allMedicamentos();
        System.out.println("CONSULTA 2");
        ps.findById(1);
        System.out.println("CONSULTA 3");
        ps.findAllWithTreatment();
        System.out.println("CONSULTA 4");
        ms.findByPerson(1);
        System.out.println("CONSULTA 5");
        ls.allLaboratoriesWithStock();
        
        System.out.println("INSERT 1");
        ts.insert(ps.findById(2),ms.findById(10));
    }

}
