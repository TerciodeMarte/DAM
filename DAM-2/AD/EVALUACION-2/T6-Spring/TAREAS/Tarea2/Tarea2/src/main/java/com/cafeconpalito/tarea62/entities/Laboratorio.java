/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "laboratorio")
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l"),
    @NamedQuery(name = "Laboratorio.findByPklaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.pklaboratorio = :pklaboratorio"),
    @NamedQuery(name = "Laboratorio.findByNombre", query = "SELECT l FROM Laboratorio l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Laboratorio.findByPvpdosis", query = "SELECT l FROM Laboratorio l WHERE l.pvpdosis = :pvpdosis")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pklaboratorio")
    private Integer pklaboratorio;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pvpdosis")
    private Float pvpdosis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aklaboratorio", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Vacuna> vacunaList;

    public Laboratorio() {
    }

    public Laboratorio(Integer pklaboratorio) {
        this.pklaboratorio = pklaboratorio;
    }

    public Integer getPklaboratorio() {
        return pklaboratorio;
    }

    public void setPklaboratorio(Integer pklaboratorio) {
        this.pklaboratorio = pklaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPvpdosis() {
        return pvpdosis;
    }

    public void setPvpdosis(Float pvpdosis) {
        this.pvpdosis = pvpdosis;
    }

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pklaboratorio != null ? pklaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.pklaboratorio == null && other.pklaboratorio != null) || (this.pklaboratorio != null && !this.pklaboratorio.equals(other.pklaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea62.entities.Laboratorio[ pklaboratorio=" + pklaboratorio + " ]";
    }

}
