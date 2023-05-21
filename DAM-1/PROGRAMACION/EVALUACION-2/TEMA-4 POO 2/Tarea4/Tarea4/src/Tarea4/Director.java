package Tarea4;

public class Director extends Persona  {
    private String direccion;
    private int horas;

    public Director() {
    }

    public Director(String direccion, int horas,int edad,double salario,String nombre) {
        this.direccion = direccion;
        this.horas = horas;
        this.edad=edad;
        this.salario=salario;
        this.nombre=nombre;
    }

    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    @Override
    public double calculoSalario(){
        return horas*salario;
    }
    public void mostrarInformación(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Direccion: "+getDireccion());
        System.out.println("Edad: "+getEdad());
        System.out.println("Salario por horas: "+ getSalario());
        System.out.println("Horas: "+getHoras());   
    }
}
