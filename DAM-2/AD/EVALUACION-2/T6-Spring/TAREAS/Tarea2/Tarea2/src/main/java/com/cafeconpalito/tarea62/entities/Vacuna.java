/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vacuna")
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByPkvacuna", query = "SELECT v FROM Vacuna v WHERE v.pkvacuna = :pkvacuna"),
    @NamedQuery(name = "Vacuna.findByStock", query = "SELECT v FROM Vacuna v WHERE v.stock = :stock")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkvacuna")
    private Integer pkvacuna;
    @Column(name = "stock")
    private Integer stock;
    @JoinColumn(name = "aklaboratorio", referencedColumnName = "pklaboratorio")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Laboratorio aklaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akvacuna", fetch = FetchType.EAGER)
    private List<Vacunapersona> vacunapersonaList;

    public Vacuna() {
    }

    public Vacuna(Integer pkvacuna) {
        this.pkvacuna = pkvacuna;
    }

    public Integer getPkvacuna() {
        return pkvacuna;
    }

    public void setPkvacuna(Integer pkvacuna) {
        this.pkvacuna = pkvacuna;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Laboratorio getAklaboratorio() {
        return aklaboratorio;
    }

    public void setAklaboratorio(Laboratorio aklaboratorio) {
        this.aklaboratorio = aklaboratorio;
    }

    public List<Vacunapersona> getVacunapersonaList() {
        return vacunapersonaList;
    }

    public void setVacunapersonaList(List<Vacunapersona> vacunapersonaList) {
        this.vacunapersonaList = vacunapersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvacuna != null ? pkvacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.pkvacuna == null && other.pkvacuna != null) || (this.pkvacuna != null && !this.pkvacuna.equals(other.pkvacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea62.entities.Vacuna[ pkvacuna=" + pkvacuna + " ]";
    }

}
