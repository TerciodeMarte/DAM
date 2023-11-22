/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.ejercicio32.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "carrito")
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c"),
    @NamedQuery(name = "Carrito.findByPkcarrito", query = "SELECT c FROM Carrito c WHERE c.pkcarrito = :pkcarrito"),
    @NamedQuery(name = "Carrito.findByFecha", query = "SELECT c FROM Carrito c WHERE c.fecha = :fecha")})
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkcarrito")
    private Integer pkcarrito;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcarrito")
    private List<Lineacarrito> lineacarritoList;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente")
    @ManyToOne(optional = false)
    private Cliente fkcliente;

    public Carrito() {
    }

    public Carrito(Integer pkcarrito) {
        this.pkcarrito = pkcarrito;
    }

    public Carrito(Integer pkcarrito, Date fecha) {
        this.pkcarrito = pkcarrito;
        this.fecha = fecha;
    }

    public Integer getPkcarrito() {
        return pkcarrito;
    }

    public void setPkcarrito(Integer pkcarrito) {
        this.pkcarrito = pkcarrito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Lineacarrito> getLineacarritoList() {
        return lineacarritoList;
    }

    public void setLineacarritoList(List<Lineacarrito> lineacarritoList) {
        this.lineacarritoList = lineacarritoList;
    }

    public Cliente getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(Cliente fkcliente) {
        this.fkcliente = fkcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcarrito != null ? pkcarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) object;
        if ((this.pkcarrito == null && other.pkcarrito != null) || (this.pkcarrito != null && !this.pkcarrito.equals(other.pkcarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.ejercicio32.Carrito[ pkcarrito=" + pkcarrito + " ]";
    }

}
