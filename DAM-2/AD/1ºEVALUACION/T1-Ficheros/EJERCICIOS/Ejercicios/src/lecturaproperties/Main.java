package lecturaproperties;

public class Main {

    public static void main(String[] args) {
        System.out.println("El directorio del usuario");
        System.out.println(System.getProperty("user.home"));
        System.out.println("El nombre del usuario");
        System.out.println(System.getProperty("user.name"));
        System.out.println("El directorio de trabajo");
        System.out.println(System.getProperty("user.dir"));
    }

}
