/**
 *
 * @author Albano Díez de Paulino
 */
public class Principal {

    /**
     * Metodo para comprar que se declarar objetos
     * @param args 
     */
    public static void main(String[] args) {
        Farmacia prod1=new Farmacia();
        prod1.setCantidad(10);
        prod1.setPrecio(2);
        prod1.setProducto("tiritas");
        
        Farmacia prod2=new Farmacia("melatonina",4,15);
        
        Farmacia prod3=new Farmacia(prod2);
        
        System.out.println(prod1.toString());
        System.out.println(prod2.toString());
        
        System.out.println(prod1.calculaPrecio());
        System.out.println(prod2.calculaPrecio());
    }

}
