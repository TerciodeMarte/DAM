package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Gestion {

    ArrayList<Personal> al;

    public Gestion() {
        al = new ArrayList();
    }

    public void añadir_empleado() {
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        String dni;
        int salario;
        do {
            System.out.println("Dime el dni del empleado");
            dni = sc.nextLine();
            if (Personal.validarDni(dni)) {
                System.out.println("DNI con formato correcto");
                control = false;
            } else {
                System.out.println("DNI con formato incorrecto");
                control = true;
            }
        } while (control);

        do {
            System.out.println("Dime el salario del empleado");
            salario = sc.nextInt();
            if (Personal.validarSalario(salario)) {
                System.out.println("Salario correcto");
                control = false;
            } else {
                System.out.println("Salario fuera del rango");
                control = true;
            }
        } while (control);

        Personal P1 = new Personal(dni, salario);

        for (Personal i : al) {
            if (P1.getDni().equalsIgnoreCase(i.getDni())) {
                control = true;
                break;
            }
        }
        if (control) {
            System.out.println("El empleado ya existe en nuestra base de datos");
        } else {
            al.add(P1);
        }

    }

    public void eliminar_empleado(String DNI) {
        Iterator<Personal> i = al.iterator();
        if (Personal.validarDni(DNI)) {
            while (i.hasNext()) {
                Personal next = i.next();
                if (next.getDni().equalsIgnoreCase(DNI)) {
                    System.out.println("Empleado encontrado,se procede a eliminarlo");
                    i.remove();
                    break;
                }
            }
        } else {
            System.out.println("Dni no valido");
        }

    }

    public void grabar_fichero() {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("empleados.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(al);
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (IOException ex) {
                System.err.println("Ha ocurrido una IOException");
            }
        }
    }

    public void leer_fichero() {
        File f = new File("empleados.dat");
        ObjectInputStream oos = null;
        FileInputStream fis = null;
        if (f.exists()) {
            try {
                fis = new FileInputStream("empleados.dat");
                oos = new ObjectInputStream(fis);
                System.out.println("Los empleados guardados en el fichero son");
                while (fis.available() > 0) {
                    System.out.println(oos.readObject().toString());

                }
            } catch (FileNotFoundException ex) {
                System.err.println("Fichero no encontrado");
            } catch (IOException ex) {
                System.err.println("Ha ocurrido una IOException");
            } catch (ClassNotFoundException ex) {
                System.err.println(ex.getMessage());
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }

                } catch (IOException ex) {
                    System.err.println("Ha ocurrido una IOException");
                }
            }
        } else {
            System.out.println("Fichero no generado aun");
        }

    }

}
