package com.cafeconpalito.tarea62;

import com.cafeconpalito.tarea62.controllers.LaboratorioController;
import com.cafeconpalito.tarea62.controllers.PersonaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tarea62Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Tarea62Application.class, args);
        LaboratorioController lc = new LaboratorioController(context);
        PersonaController pc = new PersonaController(context);

    }
    
    

}
