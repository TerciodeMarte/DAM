/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.tarea62.repositories;

import com.cafeconpalito.tarea62.entities.Laboratorio;
import com.cafeconpalito.tarea62.entities.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TerciodeMarte
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
     @Query("SELECT p FROM Vacunapersona vp inner join vp.akpersona p inner join vp.akvacuna v WHERE v.aklaboratorio = :laboratorio")
    public List<Persona> findByVacunaLaboratorio(Laboratorio laboratorio);

    @Query("SELECT p FROM Vacunapersona vp inner join vp.akpersona p inner join vp.akvacuna v inner join v.aklaboratorio l where l.nombre = :name")
    public List<Persona> findByVacunaLabName(String name);
}
