/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Game implements Serializable {

    private int id;
    
    private String nombre,genre,date,company,distribution,pegi;
    
    private String descripcion;
    
    private ImageIcon image;
    
    private String nversiona , nversionb;
    
    private double pversiona, pversionb;

    public Game() {
    }

    public Game(int id, String nombre, String genre, String date, String company, String distribution, String pegi, String descripcion, ImageIcon image, String nversiona, double pversiona) {
        this.id = id;
        this.nombre = nombre;
        this.genre = genre;
        this.date = date;
        this.company = company;
        this.distribution = distribution;
        this.pegi = pegi;
        this.descripcion = descripcion;
        this.image = image;
        this.nversiona = nversiona;
        this.pversiona = pversiona;
    }

    public Game(int id, String nombre, String genre, String date, String company, String distribution, String pegi, String descripcion, ImageIcon image, String nversiona, String nversionb, double pversiona, double pversionb) {
        this.id = id;
        this.nombre = nombre;
        this.genre = genre;
        this.date = date;
        this.company = company;
        this.distribution = distribution;
        this.pegi = pegi;
        this.descripcion = descripcion;
        this.image = image;
        this.nversiona = nversiona;
        this.nversionb = nversionb;
        this.pversiona = pversiona;
        this.pversionb = pversionb;
    }
    
    

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getNversiona() {
        return nversiona;
    }

    public void setNversiona(String nversiona) {
        this.nversiona = nversiona;
    }

    public String getNversionb() {
        return nversionb;
    }

    public void setNversionb(String nversionb) {
        this.nversionb = nversionb;
    }

    public double getPversiona() {
        return pversiona;
    }

    public void setPversiona(double pversiona) {
        this.pversiona = pversiona;
    }

    public double getPversionb() {
        return pversionb;
    }

    public void setPversionb(double pversionb) {
        this.pversionb = pversionb;
    }

    @Override
    public String toString() {
        return "Game{" + "nombre=" + nombre + ", genre=" + genre + ", date=" + date + ", company=" + company + ", descripcion=" + descripcion + ", image=" + image + ", nversiona=" + nversiona + ", nversionb=" + nversionb + ", pversiona=" + pversiona + ", pversionb=" + pversionb + '}';
    }
    
    
   
}
