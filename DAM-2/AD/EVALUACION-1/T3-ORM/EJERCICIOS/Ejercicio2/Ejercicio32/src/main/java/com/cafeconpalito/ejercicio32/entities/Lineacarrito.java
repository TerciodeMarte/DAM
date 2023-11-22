/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.ejercicio32.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "lineacarrito")
@NamedQueries({
    @NamedQuery(name = "Lineacarrito.findAll", query = "SELECT l FROM Lineacarrito l"),
    @NamedQuery(name = "Lineacarrito.findByPklinea", query = "SELECT l FROM Lineacarrito l WHERE l.pklinea = :pklinea"),
    @NamedQuery(name = "Lineacarrito.findByUnidades", query = "SELECT l FROM Lineacarrito l WHERE l.unidades = :unidades")})
public class Lineacarrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pklinea")
    private Integer pklinea;
    @Basic(optional = false)
    @Column(name = "unidades")
    private int unidades;
    @JoinColumn(name = "fkcarrito", referencedColumnName = "pkcarrito")
    @ManyToOne(optional = false)
    private Carrito fkcarrito;
    @JoinColumn(name = "fkproducto", referencedColumnName = "pkproducto")
    @ManyToOne(optional = false)
    private Producto fkproducto;

    public Lineacarrito() {
    }

    public Lineacarrito(Integer pklinea) {
        this.pklinea = pklinea;
    }

    public Lineacarrito(Integer pklinea, int unidades) {
        this.pklinea = pklinea;
        this.unidades = unidades;
    }

    public Integer getPklinea() {
        return pklinea;
    }

    public void setPklinea(Integer pklinea) {
        this.pklinea = pklinea;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Carrito getFkcarrito() {
        return fkcarrito;
    }

    public void setFkcarrito(Carrito fkcarrito) {
        this.fkcarrito = fkcarrito;
    }

    public Producto getFkproducto() {
        return fkproducto;
    }

    public void setFkproducto(Producto fkproducto) {
        this.fkproducto = fkproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pklinea != null ? pklinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineacarrito)) {
            return false;
        }
        Lineacarrito other = (Lineacarrito) object;
        if ((this.pklinea == null && other.pklinea != null) || (this.pklinea != null && !this.pklinea.equals(other.pklinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.ejercicio32.Lineacarrito[ pklinea=" + pklinea + " ]";
    }

}
