/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea61.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tratamiento")
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByPktratamiento", query = "SELECT t FROM Tratamiento t WHERE t.pktratamiento = :pktratamiento"),
    @NamedQuery(name = "Tratamiento.findByFecha", query = "SELECT t FROM Tratamiento t WHERE t.fecha = :fecha")})
public class Tratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pktratamiento")
    private Integer pktratamiento;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "akmedicina", referencedColumnName = "pkmedicamento")
    @ManyToOne(optional = false)
    private Medicamento akmedicina;
    @JoinColumn(name = "akpersona", referencedColumnName = "pkpersona")
    @ManyToOne(optional = false)
    private Persona akpersona;

    public Tratamiento() {
    }

    public Tratamiento(Integer pktratamiento) {
        this.pktratamiento = pktratamiento;
    }

    public Tratamiento(Integer pktratamiento, Date fecha) {
        this.pktratamiento = pktratamiento;
        this.fecha = fecha;
    }

    public Integer getPktratamiento() {
        return pktratamiento;
    }

    public void setPktratamiento(Integer pktratamiento) {
        this.pktratamiento = pktratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Medicamento getAkmedicina() {
        return akmedicina;
    }

    public void setAkmedicina(Medicamento akmedicina) {
        this.akmedicina = akmedicina;
    }

    public Persona getAkpersona() {
        return akpersona;
    }

    public void setAkpersona(Persona akpersona) {
        this.akpersona = akpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pktratamiento != null ? pktratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.pktratamiento == null && other.pktratamiento != null) || (this.pktratamiento != null && !this.pktratamiento.equals(other.pktratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea61.entities.Tratamiento[ pktratamiento=" + pktratamiento + " ]";
    }

}
