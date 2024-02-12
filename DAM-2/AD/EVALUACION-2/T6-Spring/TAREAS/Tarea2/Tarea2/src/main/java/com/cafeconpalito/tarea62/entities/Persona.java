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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Albano Díez de Paulino
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPkpersona", query = "SELECT p FROM Persona p WHERE p.pkpersona = :pkpersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByFechanacimiento", query = "SELECT p FROM Persona p WHERE p.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Persona.findByNdosis", query = "SELECT p FROM Persona p WHERE p.ndosis = :ndosis")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkpersona")
    private Integer pkpersona;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "ndosis")
    private Integer ndosis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akpersona", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Vacunapersona> vacunapersonaList;

    public Persona() {
    }

    public Persona(Integer pkpersona) {
        this.pkpersona = pkpersona;
    }

    public Persona(Integer pkpersona, Date fechanacimiento) {
        this.pkpersona = pkpersona;
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getPkpersona() {
        return pkpersona;
    }

    public void setPkpersona(Integer pkpersona) {
        this.pkpersona = pkpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getNdosis() {
        return ndosis;
    }

    public void setNdosis(Integer ndosis) {
        this.ndosis = ndosis;
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
        hash += (pkpersona != null ? pkpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.pkpersona == null && other.pkpersona != null) || (this.pkpersona != null && !this.pkpersona.equals(other.pkpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea62.entities.Persona[ pkpersona=" + pkpersona + " ]";
    }

}
