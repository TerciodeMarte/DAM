package ejercicioscomics;

public class CreaComic {

    public static void main(String[] args) {
        Comic c1=new Comic("Watchmen","Alan Moore","Dave Gibbons",3);
        Comic c2[]=new Comic[6];
        NovelaGrafica ng=new NovelaGrafica("Los Campbell","El Oro de San Brandamo","Jose Luis Munuera",4,56);
        
        for (int i = 0; i < 6; i++) {
            c2[i]=new Comic("Watchmen","Alan Moore","Dave Gibbons",i+1);
            c2[i].mostrarInformacion();
        }
        ng.mostrarInformacion();
      
    }
    
}
