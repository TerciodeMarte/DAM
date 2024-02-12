/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.tarea62.repositories;

import com.cafeconpalito.tarea62.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TerciodeMarte
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
}
