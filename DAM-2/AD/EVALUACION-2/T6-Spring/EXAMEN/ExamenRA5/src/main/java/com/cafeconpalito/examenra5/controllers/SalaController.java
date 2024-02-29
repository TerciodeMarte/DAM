/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.examenra5.controllers;

import com.cafeconpalito.examenra5.entities.Pelicula;
import com.cafeconpalito.examenra5.servicies.PeliculaService;
import com.cafeconpalito.examenra5.servicies.SalaService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author TerciodeMarte
 */
@RestController
@RequestMapping("/sala")
public class SalaController {
    
    SalaService ss;

    public SalaController(ApplicationContext context) {
        ss= new SalaService(context);
    }
    
    
    @GetMapping("/getnumberpeli")
    public ResponseEntity<List<Object[]>> getLaboratorioByName(){
        List<Object[]> result= ss.getNumPeli();
        if (result!=null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }  
    
}
