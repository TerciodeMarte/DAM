/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.pruebahibernate;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author carra
 */
public class PruebaHibernate {

    public static void main(String[] args) {
        System.out.println("Hello There");
        
        //Creo la conexion
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.cafeconpalito_PruebaHibernate_jar_1.0PU");
        EntityManager em =emf.createEntityManager();
        
        Query c1 = em.createNamedQuery("Cliente.findAll");
        
        ArrayList<Cliente> al= (ArrayList<Cliente>) c1.getResultList();
        for (Cliente cliente : al) {
            System.out.println(cliente.getNombre());
        }
        
        //Cierro la conexion
        em.close();
        emf.close();
        
    }
}
