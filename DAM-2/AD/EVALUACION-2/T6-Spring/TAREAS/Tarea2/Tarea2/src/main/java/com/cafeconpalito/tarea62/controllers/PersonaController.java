/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea62.controllers;

import com.cafeconpalito.tarea62.entities.Laboratorio;
import com.cafeconpalito.tarea62.entities.Persona;
import com.cafeconpalito.tarea62.services.PersonaService;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Albano Díez de Paulino
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    PersonaService ps;

    public PersonaController(ApplicationContext context) {
        ps = new PersonaService(context);
    }

    @GetMapping("/{ndosis}")
    public ResponseEntity<List<Persona>> getPersonWithVaccineNumber(@PathVariable Integer ndosis) {
        List<Persona> result = ps.personasConNdosis(ndosis);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/laboratorio/{name}")
    public ResponseEntity<List<Persona>> getPersonWithVaccineLaboratoryName(String lab) {
        List<Persona> result = ps.personasConVacunaLaboratorio(lab);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/laboratorio/")
    public ResponseEntity<List<Persona>> getPersonWithVaccineLaboratory(@RequestBody Laboratorio lab) {
        List<Persona> result = ps.personasConVacunaLaboratorio(lab);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/laboratorio/")
    public ResponseEntity<Persona> insertPerson(@RequestBody Persona persona) {

        return ResponseEntity.ok(ps.addPersona(persona));

    }

}
