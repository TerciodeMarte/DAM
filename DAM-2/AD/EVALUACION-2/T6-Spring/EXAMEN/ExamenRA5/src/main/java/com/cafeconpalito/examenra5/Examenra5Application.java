package com.cafeconpalito.examenra5;

import com.cafeconpalito.examenra5.controllers.EntradaController;
import com.cafeconpalito.examenra5.controllers.PeliculaController;
import com.cafeconpalito.examenra5.controllers.SalaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Examenra5Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Examenra5Application.class, args);
        
        PeliculaController pc = new PeliculaController(context);
        SalaController sc = new SalaController(context);
        EntradaController ec = new EntradaController(context);

    }

}
