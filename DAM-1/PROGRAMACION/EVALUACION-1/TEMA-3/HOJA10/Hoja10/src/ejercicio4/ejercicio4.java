
package ejercicio4;

public class ejercicio4 {

    public static void main(String[] args) {
        Ciudad ciudad1 = new Ciudad();
        Ciudad ciudad2= new Ciudad("Honolulu","Waikiki Beach",88);
        
        ciudad1.setNombre("Paris");
        ciudad1.setSimbolo("Torre Eiffel");
        ciudad1.setTemperatura(20);
        
        System.out.println("La temperatura media de la ciudad de "+ciudad1.getNombre()+" en grados Farenheit es " +Ciudad.celsiusAFarenheit(ciudad1.getTemperatura()));
        System.out.println("La temperatura media de la ciudad de "+ciudad2.getNombre()+" en grados Farenheit es " +Ciudad.farenheitACelsius(ciudad2.getTemperatura()));
        
        
        
    }
    
}
