/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.tarea62.controllers;

import com.cafeconpalito.tarea62.entities.Laboratorio;
import com.cafeconpalito.tarea62.services.LaboratorioService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author TerciodeMarte
 */
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
    
    LaboratorioService ls;

    public LaboratorioController(ApplicationContext context) {
        ls= new LaboratorioService(context);
    }
    
    @GetMapping("/getall")
    public ResponseEntity<List<Laboratorio>> getAllLaboratorios(){
        List<Laboratorio> result= ls.findAll();
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
