
package ejemplo6;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;
import ejemplo1.Estudiante;

public class Ejemplo6 {

    
    public static void main(String[] args) {
        
        
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Estudiante.class).cascadeOnDelete(true);
        ObjectContainer bd=Db4oEmbedded.openFile(config, "Ejemplo");
        
        Query consulta;
        Query borrado=bd.query();
        ObjectSet resultado;
        
        borrado.constrain(Estudiante.class);
        borrado.descend("nota").constrain(5).greater();
        resultado=borrado.execute();
        
        while (resultado.hasNext()){
            Estudiante e = (Estudiante) resultado.next();
            bd.delete(e);
        }
        
        System.out.println("Así queda la base de datos:");
        consulta=bd.query();
        consulta.constrain(Estudiante.class);
        resultado=consulta.execute();
        while (resultado.hasNext()){
            Estudiante e = (Estudiante) resultado.next();
            e.info();
        }
        
        bd.close();
    
    }
    
    
    
}
