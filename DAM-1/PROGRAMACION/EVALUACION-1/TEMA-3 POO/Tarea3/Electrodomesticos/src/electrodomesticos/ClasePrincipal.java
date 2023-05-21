package electrodomesticos;

public class ClasePrincipal {
    public static void main(String[] args) {
        // Crea un objeto electrodomestico1 con el constructor por defecto
        Electrodomestico electrodomestico1 = new Electrodomestico();

        // Consulta sus atributos
        System.out.println("ELECTRODOMESTICO 1 SIN MODIFICADAR");
        System.out.println("Numero de Serie: " + electrodomestico1.getNumSerie());
        System.out.println("Marca: " + electrodomestico1.getMarca());
        System.out.println("Precio: " + electrodomestico1.getPrecio()+" e");
        System.out.println("");

        // Cambia los atributos del objeto
        electrodomestico1.setNumSerie("NS1234");
        electrodomestico1.setMarca("Siemens");

        // Consulta sus atributos del objeto 1
        System.out.println("ELECTRODOMESTICO 1 MODIFICADO");
        System.out.println("Numero de Serie: " + electrodomestico1.getNumSerie());
        System.out.println("Marca: " + electrodomestico1.getMarca());
        System.out.println("Precio: " + electrodomestico1.getPrecio()+" e");
        System.out.println("");

        // Crea un objeto electrodomestico2 con el constructor con argumentos
        Electrodomestico electrodomestico2 = new Electrodomestico("RM4321", "Toshiba", 30.11);

        // Consulta atributos objeto 2 sin modificar
        System.out.println("ELECTRODOMESTICO 2");
        System.out.println("Numero de Serie: " + electrodomestico2.getNumSerie());
        System.out.println("Marca: " + electrodomestico2.getMarca());
        System.out.println("Precio: " + electrodomestico2.getPrecio()+" e");

        // Aplica el método aplicarIva al objeto 2
        electrodomestico2.aplicarIva();
        System.out.println("Precio + IVA: " + Math.round(electrodomestico2.getPrecio()*100.0)/100.0+" e");

        // Aplica el método rebajarPrecio al objeto 2 varias veces 20%,30%,60%
        electrodomestico2.rebajarPrecio(20);
        System.out.println("Precio aplicando de una rebaja del 20%: " + Math.round(electrodomestico2.getPrecio()*100.0)/100.0+" e");
        electrodomestico2.rebajarPrecio(30);
        System.out.println("Precio aplicando de una rebaja del 30%: " + Math.round(electrodomestico2.getPrecio()*100.0)/100.0+" e");
        electrodomestico2.rebajarPrecio(60);
        System.out.println("Precio aplicando de una rebaja del 60%: " + Math.round(electrodomestico2.getPrecio()*100.0)/100.0+" e");
    }
}

