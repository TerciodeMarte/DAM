package com.cafeconpalito.ejemplo1;

import com.cafeconpalito.ejemplo1.entities.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import com.cafeconpalito.ejemplo1.repositories.IEmpleadosDAO;

@SpringBootApplication
public class Ejemplo1Application {

    @Autowired()
    private IEmpleadosDAO empleadodao;

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(Ejemplo1Application.class, args);
    }
    
    @EventListener ({ApplicationReadyEvent.class})
    public void pruebaConsultas(){
        try{
           List<Empleado> lista = (List<Empleado>) empleadodao.findAll();
            for (Empleado e : lista) {
                System.out.println(e.getPkempleado() + "-" + e.getNombre() + "-" + e.getNombre());
            }
        }catch (IllegalArgumentException ex){
            System.err.println("Error: " + ex.getMessage() );
        }
        System.exit(0);
    }

}
