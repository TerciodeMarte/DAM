/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.tarea61.repositories;

import com.cafeconpalito.tarea61.entities.Laboratorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TerciodeMarte
 */
@Repository
public interface ILaboratorio extends JpaRepository<Laboratorio, Integer> {
    @Query("select l from Medicamento m inner join m.aklaboratorio l order by m.pvp asc")
    public List<Laboratorio> allLaboratoriesWithStock();
}
