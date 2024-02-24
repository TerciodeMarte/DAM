/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea62.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "vacunapersona")
@NamedQueries({
    @NamedQuery(name = "Vacunapersona.findAll", query = "SELECT v FROM Vacunapersona v"),
    @NamedQuery(name = "Vacunapersona.findByPkvacunapersona", query = "SELECT v FROM Vacunapersona v WHERE v.pkvacunapersona = :pkvacunapersona"),
    @NamedQuery(name = "Vacunapersona.findByFecha", query = "SELECT v FROM Vacunapersona v WHERE v.fecha = :fecha")})
public class Vacunapersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkvacunapersona")
    private Integer pkvacunapersona;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "akpersona", referencedColumnName = "pkpersona")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona akpersona;
    @JoinColumn(name = "akvacuna", referencedColumnName = "pkvacuna")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vacuna akvacuna;

    public Vacunapersona() {
    }

    public Vacunapersona(Integer pkvacunapersona) {
        this.pkvacunapersona = pkvacunapersona;
    }

    public Vacunapersona(Integer pkvacunapersona, Date fecha) {
        this.pkvacunapersona = pkvacunapersona;
        this.fecha = fecha;
    }

    public Integer getPkvacunapersona() {
        return pkvacunapersona;
    }

    public void setPkvacunapersona(Integer pkvacunapersona) {
        this.pkvacunapersona = pkvacunapersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getAkpersona() {
        return akpersona;
    }

    public void setAkpersona(Persona akpersona) {
        this.akpersona = akpersona;
    }

    public Vacuna getAkvacuna() {
        return akvacuna;
    }

    public void setAkvacuna(Vacuna akvacuna) {
        this.akvacuna = akvacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvacunapersona != null ? pkvacunapersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunapersona)) {
            return false;
        }
        Vacunapersona other = (Vacunapersona) object;
        if ((this.pkvacunapersona == null && other.pkvacunapersona != null) || (this.pkvacunapersona != null && !this.pkvacunapersona.equals(other.pkvacunapersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea62.entities.Vacunapersona[ pkvacunapersona=" + pkvacunapersona + " ]";
    }

}
