package ejercicio6;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Bonoloto {
    private int array[] = new int[6];

    public Bonoloto() {
        //No se si este metodo funciona,si supiera hacer pruebas de caja blanca pues seria mejor
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*(49 - 1) + 1);//random*(max - min) + min
            for (int j = 0; j <i ; j++) {
                if (array[i]==array[j]) {
                    array[i]=(int)(Math.random()*(49 - 1) + 1);
                }
            }     
        }
    }
    
    public String mostrar(){
        String aux="";
        for (int i = 0; i < array.length; i++) {
            aux=aux+" "+array[i];
        }
        return aux;
    }
    
    
}
