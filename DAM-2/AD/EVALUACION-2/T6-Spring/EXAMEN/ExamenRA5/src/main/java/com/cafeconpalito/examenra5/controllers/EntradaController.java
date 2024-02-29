/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.examenra5.controllers;

import com.cafeconpalito.examenra5.entities.Entrada;
import com.cafeconpalito.examenra5.servicies.EntradaService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author TerciodeMarte
 */
@RestController
@RequestMapping("/pelicula")
public class EntradaController {
    
    EntradaService es;

    public EntradaController(ApplicationContext context) {
        es= new EntradaService(context);
    }
    
     @PutMapping("/insert")
    public ResponseEntity<Entrada> insertPerson(Integer pksocio,Integer pkproyeccion,Integer numentradas) {

         System.out.println("ENVIO CORRECTO");
        return ResponseEntity.ok(es.insert(pksocio,pkproyeccion,numentradas));

    }
}
