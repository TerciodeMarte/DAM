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
@Table(name = "sala")
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findByPksala", query = "SELECT s FROM Sala s WHERE s.pksala = :pksala"),
    @NamedQuery(name = "Sala.findByNombre", query = "SELECT s FROM Sala s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sala.findByAforo", query = "SELECT s FROM Sala s WHERE s.aforo = :aforo")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pksala")
    private Integer pksala;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "aforo")
    private int aforo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fksala", fetch = FetchType.EAGER)
    private List<Proyeccion> proyeccionList;

    public Sala() {
    }

    public Sala(Integer pksala) {
        this.pksala = pksala;
    }

    public Sala(Integer pksala, String nombre, int aforo) {
        this.pksala = pksala;
        this.nombre = nombre;
        this.aforo = aforo;
    }

    public Integer getPksala() {
        return pksala;
    }

    public void setPksala(Integer pksala) {
        this.pksala = pksala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public List<Proyeccion> getProyeccionList() {
        return proyeccionList;
    }

    public void setProyeccionList(List<Proyeccion> proyeccionList) {
        this.proyeccionList = proyeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pksala != null ? pksala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.pksala == null && other.pksala != null) || (this.pksala != null && !this.pksala.equals(other.pksala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.examenra5.entities.Sala[ pksala=" + pksala + " ]";
    }

}
