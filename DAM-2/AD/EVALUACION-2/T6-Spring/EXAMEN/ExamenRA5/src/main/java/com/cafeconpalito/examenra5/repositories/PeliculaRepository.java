/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.examenra5.repositories;

import com.cafeconpalito.examenra5.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TerciodeMarte
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    
}
