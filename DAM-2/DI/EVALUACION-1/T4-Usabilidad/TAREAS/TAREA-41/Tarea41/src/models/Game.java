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

    private String nombre, genre, date, company, distribution, pegi;

    private String descripcion;

    private ImageIcon image;

    private String version;

    private double precio;

    public Game() {
    }

    public Game(String nombre, String genre, String date, String company, String distribution, String pegi, String descripcion, ImageIcon image, String version, double precio) {
        this.nombre = nombre;
        this.genre = genre;
        this.date = date;
        this.company = company;
        this.distribution = distribution;
        this.pegi = pegi;
        this.descripcion = descripcion;
        this.image = image;
        this.version = version;
        this.precio = precio;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Game{" + "nombre=" + nombre + ", genre=" + genre + ", date=" + date + ", company=" + company + ", distribution=" + distribution + ", pegi=" + pegi + ", descripcion=" + descripcion + ", image=" + image + ", version=" + version + ", precio=" + precio + '}';
    }


}
