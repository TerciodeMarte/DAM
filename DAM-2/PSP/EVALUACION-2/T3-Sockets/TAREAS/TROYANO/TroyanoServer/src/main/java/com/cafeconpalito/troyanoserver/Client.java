package com.cafeconpalito.troyanoserver;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Client {

    private String so, ip, usuario, arquitectura, versionso, currentdir, userhome;

    public Client(String so, String ip, String usuario, String arquitectura, String versionso, String currentdir, String userhome) {
        this.so = so;
        this.ip = ip;
        this.usuario = usuario;
        this.arquitectura = arquitectura;
        this.versionso = versionso;
        this.currentdir = currentdir;
        this.userhome = userhome;
    }

    public Client() {
    }

    
    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    public String getVersionso() {
        return versionso;
    }

    public void setVersionso(String versionso) {
        this.versionso = versionso;
    }

    public String getCurrentdir() {
        return currentdir;
    }

    public void setCurrentdir(String currentdir) {
        this.currentdir = currentdir;
    }

    public String getUserhome() {
        return userhome;
    }

    public void setUserhome(String userhome) {
        this.userhome = userhome;
    }

    @Override
    public String toString() {
        return "Client{" + "so=" + so + ", ip=" + ip + ", usuario=" + usuario + ", arquitectura=" + arquitectura + ", versionso=" + versionso + ", currentdir=" + currentdir + ", userhome=" + userhome + '}';
    }
    
    
    
    

}
