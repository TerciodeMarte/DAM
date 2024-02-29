/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.examenra5.entities;

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
@Table(name = "pelicula")
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByPkpelicula", query = "SELECT p FROM Pelicula p WHERE p.pkpelicula = :pkpelicula"),
    @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Pelicula.findByMinutos", query = "SELECT p FROM Pelicula p WHERE p.minutos = :minutos")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkpelicula")
    private Integer pkpelicula;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "minutos")
    private int minutos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkpelicula", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Proyeccion> proyeccionList;

    public Pelicula() {
    }

    public Pelicula(Integer pkpelicula) {
        this.pkpelicula = pkpelicula;
    }

    public Pelicula(Integer pkpelicula, String titulo, int minutos) {
        this.pkpelicula = pkpelicula;
        this.titulo = titulo;
        this.minutos = minutos;
    }

    public Integer getPkpelicula() {
        return pkpelicula;
    }

    public void setPkpelicula(Integer pkpelicula) {
        this.pkpelicula = pkpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
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
        hash += (pkpelicula != null ? pkpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.pkpelicula == null && other.pkpelicula != null) || (this.pkpelicula != null && !this.pkpelicula.equals(other.pkpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.examenra5.entities.Pelicula[ pkpelicula=" + pkpelicula + " ]";
    }

}
