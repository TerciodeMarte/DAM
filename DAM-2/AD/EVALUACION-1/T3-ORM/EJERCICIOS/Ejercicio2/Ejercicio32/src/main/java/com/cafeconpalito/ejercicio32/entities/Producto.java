/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.ejercicio32.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByPkproducto", query = "SELECT p FROM Producto p WHERE p.pkproducto = :pkproducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByPvp", query = "SELECT p FROM Producto p WHERE p.pvp = :pvp"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByNameAndStock", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre and p.stock > :stock")
})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkproducto")
    private Integer pkproducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pvp")
    private BigDecimal pvp;
    @Column(name = "stock")
    private Integer stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkproducto")
    private List<Lineacarrito> lineacarritoList;
    @JoinColumn(name = "fkcategoria", referencedColumnName = "pkcategoria")
    @ManyToOne(optional = false)
    private Categoria fkcategoria;

    public Producto() {
    }

    public Producto(Integer pkproducto) {
        this.pkproducto = pkproducto;
    }

    public Producto(Integer pkproducto, String nombre, BigDecimal pvp) {
        this.pkproducto = pkproducto;
        this.nombre = nombre;
        this.pvp = pvp;
    }

    public Integer getPkproducto() {
        return pkproducto;
    }

    public void setPkproducto(Integer pkproducto) {
        this.pkproducto = pkproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Lineacarrito> getLineacarritoList() {
        return lineacarritoList;
    }

    public void setLineacarritoList(List<Lineacarrito> lineacarritoList) {
        this.lineacarritoList = lineacarritoList;
    }

    public Categoria getFkcategoria() {
        return fkcategoria;
    }

    public void setFkcategoria(Categoria fkcategoria) {
        this.fkcategoria = fkcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkproducto != null ? pkproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.pkproducto == null && other.pkproducto != null) || (this.pkproducto != null && !this.pkproducto.equals(other.pkproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.ejercicio32.Producto[ pkproducto=" + pkproducto + " ]";
    }

}
