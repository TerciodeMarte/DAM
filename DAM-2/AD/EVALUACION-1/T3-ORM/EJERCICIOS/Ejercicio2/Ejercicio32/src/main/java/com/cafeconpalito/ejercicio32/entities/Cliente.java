/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.ejercicio32.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByPkcliente", query = "SELECT c FROM Cliente c WHERE c.pkcliente = :pkcliente"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByPassword", query = "SELECT c FROM Cliente c WHERE c.password = :password"),
})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkcliente")
    private Integer pkcliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente")
    private List<Carrito> carritoList;

    public Cliente() {
    }

    public Cliente(Integer pkcliente) {
        this.pkcliente = pkcliente;
    }

    public Cliente(Integer pkcliente, String nombre, String password) {
        this.pkcliente = pkcliente;
        this.nombre = nombre;
        this.password = password;
    }

    public Integer getPkcliente() {
        return pkcliente;
    }

    public void setPkcliente(Integer pkcliente) {
        this.pkcliente = pkcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Carrito> getCarritoList() {
        return carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcliente != null ? pkcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkcliente == null && other.pkcliente != null) || (this.pkcliente != null && !this.pkcliente.equals(other.pkcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.ejercicio32.Cliente[ pkcliente=" + pkcliente + " ]";
    }

}
