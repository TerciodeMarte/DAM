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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "proyeccion")
@NamedQueries({
    @NamedQuery(name = "Proyeccion.findAll", query = "SELECT p FROM Proyeccion p"),
    @NamedQuery(name = "Proyeccion.findByPkproyeccion", query = "SELECT p FROM Proyeccion p WHERE p.pkproyeccion = :pkproyeccion"),
    @NamedQuery(name = "Proyeccion.findByFecha", query = "SELECT p FROM Proyeccion p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Proyeccion.findByNumentradas", query = "SELECT p FROM Proyeccion p WHERE p.numentradas = :numentradas")})
public class Proyeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkproyeccion")
    private Integer pkproyeccion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "numentradas")
    private Integer numentradas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkproyeccion", fetch = FetchType.EAGER)
    private List<Entrada> entradaList;
    @JoinColumn(name = "fkpelicula", referencedColumnName = "pkpelicula")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pelicula fkpelicula;
    @JoinColumn(name = "fksala", referencedColumnName = "pksala")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sala fksala;

    public Proyeccion() {
    }

    public Proyeccion(Integer pkproyeccion) {
        this.pkproyeccion = pkproyeccion;
    }

    public Proyeccion(Integer pkproyeccion, Date fecha) {
        this.pkproyeccion = pkproyeccion;
        this.fecha = fecha;
    }

    public Integer getPkproyeccion() {
        return pkproyeccion;
    }

    public void setPkproyeccion(Integer pkproyeccion) {
        this.pkproyeccion = pkproyeccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumentradas() {
        return numentradas;
    }

    public void setNumentradas(Integer numentradas) {
        this.numentradas = numentradas;
    }

    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    public Pelicula getFkpelicula() {
        return fkpelicula;
    }

    public void setFkpelicula(Pelicula fkpelicula) {
        this.fkpelicula = fkpelicula;
    }

    public Sala getFksala() {
        return fksala;
    }

    public void setFksala(Sala fksala) {
        this.fksala = fksala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkproyeccion != null ? pkproyeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyeccion)) {
            return false;
        }
        Proyeccion other = (Proyeccion) object;
        if ((this.pkproyeccion == null && other.pkproyeccion != null) || (this.pkproyeccion != null && !this.pkproyeccion.equals(other.pkproyeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.examenra5.entities.Proyeccion[ pkproyeccion=" + pkproyeccion + " ]";
    }

}
