package Main;

/**
 *
 * @author Albano Díez de Paulino
 */
public class User {

    private String user;
    private String name;
    private String ruta;
    private String pass;

    public User(String user, String name, String ruta, String pass) {
        this.user = user;
        this.name = name;
        this.ruta = ruta;
        this.pass = pass;
    }

    public User() {
    }
   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    

   

}
