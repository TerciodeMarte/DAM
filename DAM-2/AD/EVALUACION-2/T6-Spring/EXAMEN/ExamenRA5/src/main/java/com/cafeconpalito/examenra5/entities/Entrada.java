/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "entrada")
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByPkentrada", query = "SELECT e FROM Entrada e WHERE e.pkentrada = :pkentrada")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkentrada")
    private Integer pkentrada;
    @JoinColumn(name = "fkproyeccion", referencedColumnName = "pkproyeccion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonIgnore
    private Proyeccion fkproyeccion;
    @JoinColumn(name = "fksocio", referencedColumnName = "pksocio")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonIgnore
    private Socio fksocio;

    public Entrada() {
    }

    public Entrada(Integer pkentrada) {
        this.pkentrada = pkentrada;
    }

    public Integer getPkentrada() {
        return pkentrada;
    }

    public void setPkentrada(Integer pkentrada) {
        this.pkentrada = pkentrada;
    }

    public Proyeccion getFkproyeccion() {
        return fkproyeccion;
    }

    public void setFkproyeccion(Proyeccion fkproyeccion) {
        this.fkproyeccion = fkproyeccion;
    }

    public Socio getFksocio() {
        return fksocio;
    }

    public void setFksocio(Socio fksocio) {
        this.fksocio = fksocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkentrada != null ? pkentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.pkentrada == null && other.pkentrada != null) || (this.pkentrada != null && !this.pkentrada.equals(other.pkentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.examenra5.entities.Entrada[ pkentrada=" + pkentrada + " ]";
    }

}
