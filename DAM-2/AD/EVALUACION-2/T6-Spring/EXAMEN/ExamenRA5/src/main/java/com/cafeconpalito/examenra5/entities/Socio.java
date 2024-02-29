/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "socio")
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByPksocio", query = "SELECT s FROM Socio s WHERE s.pksocio = :pksocio"),
    @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Socio.findByLocalidad", query = "SELECT s FROM Socio s WHERE s.localidad = :localidad")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pksocio")
    private Integer pksocio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "localidad")
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fksocio", fetch = FetchType.EAGER)
    private List<Entrada> entradaList;

    public Socio() {
    }

    public Socio(Integer pksocio) {
        this.pksocio = pksocio;
    }

    public Socio(Integer pksocio, String nombre) {
        this.pksocio = pksocio;
        this.nombre = nombre;
    }

    public Integer getPksocio() {
        return pksocio;
    }

    public void setPksocio(Integer pksocio) {
        this.pksocio = pksocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pksocio != null ? pksocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.pksocio == null && other.pksocio != null) || (this.pksocio != null && !this.pksocio.equals(other.pksocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.examenra5.entities.Socio[ pksocio=" + pksocio + " ]";
    }

}
