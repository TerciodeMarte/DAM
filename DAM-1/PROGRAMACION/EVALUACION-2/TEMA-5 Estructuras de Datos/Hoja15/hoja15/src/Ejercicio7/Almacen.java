package Ejercicio7;

import java.util.ArrayList;

public class Almacen {

    private ArrayList<Coche> vehiculos = new ArrayList();

    public Almacen() {
    }

    public Almacen(Almacen almacen) {
        vehiculos.addAll(almacen.vehiculos);
    }

    public void add_coche(Coche vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void add_coche(int pos, Coche vehiculo) {

        vehiculos.add(pos, vehiculo);

    }

    public void remove_coche(Coche vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void remove_coche(int pos) {
        if (vehiculos.get(pos) == null) {
            System.out.println("No existe un coche en esa posicion");
        } else {
            vehiculos.remove(pos);
        }
    }

    public void visualiza_coches() {
        System.out.println("Lista de coches registrados:");
        for (Coche coche : vehiculos) {
            System.out.println(coche.toString());
        }
    }

    public void buscar(int pos) {
        if (vehiculos.get(pos) == null) {
            System.out.println("No existe un coche en esa posicion");
        } else {
            System.out.println(vehiculos.get(pos).toString());
        }
    }

    public String buscar(Coche vehiculo) {
        for (Coche v : vehiculos) {
            if (v.getColor().equalsIgnoreCase(vehiculo.getColor()) && v.getMarca().equalsIgnoreCase(vehiculo.getMarca())) {
                return "El coche existe en el almacen";
            }
        }
        return "El coche no existe en el almacen";
    }

    public int tamano_almacen() {
        return vehiculos.size();
    }

}
