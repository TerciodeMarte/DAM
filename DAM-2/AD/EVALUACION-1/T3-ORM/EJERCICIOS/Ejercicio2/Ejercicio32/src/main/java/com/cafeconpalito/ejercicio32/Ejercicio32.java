/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ejercicio32;

import com.cafeconpalito.ejercicio32.entities.Producto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author carra
 */
public class Ejercicio32 {

    public static void main(String[] args) {
        //Creo la conexion
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cafeconpalito_Ejercicio32_jar_1.0PU");
        EntityManager em = emf.createEntityManager();

        //busqueda1(em);
        //busqueda2(em);
        //busqueda3(em);
        insert(em);

        //Cierro la conexion
        em.close();
        emf.close();
    }

    /**
     * a. Método que muestra por pantalla el listado de productos: pkproducto,
     * nombre, precio, nombre de la categoría.
     *
     * @param em
     */
    private static void busqueda1(EntityManager em) {
        //Busqueda
        ArrayList<Producto> listaProductos = (ArrayList<Producto>) em.createNamedQuery("Producto.findAll").getResultList();
        for (Producto p : listaProductos) {
            System.out.println("ID Producto: " + p.getPkproducto() + " Nombre producto: " + p.getNombre() + " Precio: " + p.getPvp() + " Categoria: " + p.getFkcategoria().getNombre());
        }
    }

    /**
     * b. Método que muestra por pantalla todos los datos de un producto a
     * partir de su pkproducto.
     *
     * @param em
     */
    private static void busqueda2(EntityManager em) {
        //Busqueda
        ArrayList<Producto> listaProductos = (ArrayList<Producto>) em.createNamedQuery("Producto.findByPkproducto").setParameter("pkproducto", 1).getResultList();
        for (Producto p : listaProductos) {
            System.out.println("ID Producto: " + p.getPkproducto() + " Nombre producto: " + p.getNombre() + " Precio: " + p.getPvp() + " Categoria: " + p.getFkcategoria().getNombre());
        }
    }

    /**
     * 6. Realiza una consulta JPQL inventada por ti.
     *
     * @param em
     */
    private static void busqueda3(EntityManager em) {
        //Busqueda
        Query c1 = em.createNamedQuery("Producto.findByNameAndStock");

        c1.setParameter("nombre", "iPhone 12");
        c1.setParameter("stock", 20);

        ArrayList<Producto> listaProductos = (ArrayList<Producto>) c1.getResultList();
        for (Producto p : listaProductos) {
            System.out.println("ID Producto: " + p.getPkproducto() + " Nombre producto: " + p.getNombre() + " Precio: " + p.getPvp() + " Categoria: " + p.getFkcategoria().getNombre());
        }
    }

    /**
     * 7. Realiza un método que inserte un registro nuevo en la base de datos. 
     * @param em 
     */
    private static void insert(EntityManager em) {
        //Busqueda
        Query insercion = em.createNativeQuery("INSERT INTO Cliente (nombre, password) VALUES (:nombre , :password);");
        em.getTransaction().begin();
        insercion.setParameter("nombre", "Albano");
        insercion.setParameter("password", "1234");
        insercion.executeUpdate();
        em.getTransaction().commit();

    }
}
