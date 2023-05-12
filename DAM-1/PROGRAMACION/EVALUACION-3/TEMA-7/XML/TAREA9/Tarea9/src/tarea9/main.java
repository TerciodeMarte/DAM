package tarea9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Albano Díez de Paulino
 */
public class main {

    public static void main(String[] args) {
        boolean exit=true;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("1- Crear fichero XML");
            System.out.println("2- Leer fichero XML");
            System.out.println("3- Salir");
            byte x=sc.nextByte();
            switch (x) {
                case 1:
                    escritura();
                    break;
                case 2:
                    lectura();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    exit=false;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        } while (exit);
    }

    /**
     * Metodo para crear un xml de libros
     */
    private static void escritura() {
        boolean isnumero = false;
        int numerolibros = 0;
        String titulo, autor;
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoint = new Scanner(System.in);

        FileWriter fw = null;

        try {

            do {
                try {
                    System.out.println("Cuantos libros quieres introducir");
                    numerolibros = tecladoint.nextInt();
                    if (numerolibros < 0) {
                        System.err.println("No se pueden introducir numeros negativos");
                        isnumero = true;
                    } else {
                        fw = new FileWriter("libros.xml");
                        fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                        fw.write("<libros>");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Introduce un numero");
                    isnumero = true;
                }
            } while (isnumero);

            for (int i = 0; i < numerolibros; i++) {
                System.out.println("Dime el titulo del libro");
                titulo = teclado.nextLine();
                System.out.println("Dime el autor del libro");
                autor = teclado.nextLine();
                fw.write("\n\t<libro>\n\t\t<titulo> " + titulo + "</titulo>\n" + "\t\t<autor>" + autor + "</autor>\n\t</libro>");
            }

            fw.write("\n</libros>");
        } catch (IOException e) {
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException.");
            }
        }
    }
    
    /**
     * Metodo para leer el xml generado con metodo escritura()
     */
    private static void lectura(){
        try {
            ArrayList<Libros> ar=new ArrayList<>();
            //Objetos necesarios para parsear el archivo.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = dbf.newDocumentBuilder();

            //Accedemos al fichero que queremos leer.
            Document d = b.parse("libros.xml");

            //Elemento raíz.
            Element raiz = d.getDocumentElement();

            NodeList libros = raiz.getElementsByTagName("libro");

            for (int i = 0; i < libros.getLength(); i++) {
                Node n = libros.item(i);
                
               if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    Libros l1=new Libros();
                    l1.setTitulo(e.getElementsByTagName("titulo").item(0).getTextContent());
                    l1.setAutor(e.getElementsByTagName("autor").item(0).getTextContent());
                    ar.add(l1);
                    System.out.println("El "+(i+1)+" libro es " + ar.get(i).getTitulo() + " de " + ar.get(i).getAutor());
                }
            }
        } catch (IOException ex) {
            System.err.println("No se ha podido leer el fichero XML.");
        } catch (SAXException ex) {
            System.err.println("No se ha podido parsear el fichero XML.");
        } catch (Exception ex) {
            System.err.println("Ha ocurrido una error.");
        }
    }

}
/**
 * Clase para almacenar libros
 * @author Albano Díez de Paulino
 */
class Libros{
     private String titulo,autor;

    public Libros() {
    }

    public Libros(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
