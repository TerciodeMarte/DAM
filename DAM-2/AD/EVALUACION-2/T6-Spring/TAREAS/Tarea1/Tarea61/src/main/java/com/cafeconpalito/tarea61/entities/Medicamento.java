/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.tarea61.entities;

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
@Table(name = "medicamento")
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findByPkmedicamento", query = "SELECT m FROM Medicamento m WHERE m.pkmedicamento = :pkmedicamento"),
    @NamedQuery(name = "Medicamento.findByFormato", query = "SELECT m FROM Medicamento m WHERE m.formato = :formato"),
    @NamedQuery(name = "Medicamento.findByStock", query = "SELECT m FROM Medicamento m WHERE m.stock = :stock"),
    @NamedQuery(name = "Medicamento.findByPvp", query = "SELECT m FROM Medicamento m WHERE m.pvp = :pvp")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkmedicamento")
    private Integer pkmedicamento;
    @Column(name = "formato")
    private String formato;
    @Column(name = "stock")
    private Integer stock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pvp")
    private Float pvp;
    @JoinColumn(name = "aklaboratorio", referencedColumnName = "pklaboratorio")
    @ManyToOne(optional = false)
    private Laboratorio aklaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akmedicina",fetch = FetchType.EAGER)
    private List<Tratamiento> tratamientoList;

    public Medicamento() {
    }

    public Medicamento(Integer pkmedicamento) {
        this.pkmedicamento = pkmedicamento;
    }

    public Integer getPkmedicamento() {
        return pkmedicamento;
    }

    public void setPkmedicamento(Integer pkmedicamento) {
        this.pkmedicamento = pkmedicamento;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPvp() {
        return pvp;
    }

    public void setPvp(Float pvp) {
        this.pvp = pvp;
    }

    public Laboratorio getAklaboratorio() {
        return aklaboratorio;
    }

    public void setAklaboratorio(Laboratorio aklaboratorio) {
        this.aklaboratorio = aklaboratorio;
    }

    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkmedicamento != null ? pkmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.pkmedicamento == null && other.pkmedicamento != null) || (this.pkmedicamento != null && !this.pkmedicamento.equals(other.pkmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.tarea61.entities.Medicamento[ pkmedicamento=" + pkmedicamento + " ]";
    }

}
