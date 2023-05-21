package ejercicio4;

public class Ciudad {
    private String nombre,simbolo;
    private int temperatura;

    public Ciudad() {
    }

    public Ciudad(String nombre, String simbolo, int temperatura) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.temperatura = temperatura;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    
    public static double celsiusAFarenheit(int temperaturacelsius){
        return (1.8*temperaturacelsius) +32;
    }
    public static double farenheitACelsius(int temperaturafarenheit){
        return (temperaturafarenheit-32)/1.8;
    }
}
