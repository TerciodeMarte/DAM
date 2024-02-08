/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.ejemplo1.repositories;

import com.cafeconpalito.ejemplo1.entities.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author carra
 */
@Repository
public interface IEmpleadosDAO extends CrudRepository<Empleado, Integer> {
    
}
