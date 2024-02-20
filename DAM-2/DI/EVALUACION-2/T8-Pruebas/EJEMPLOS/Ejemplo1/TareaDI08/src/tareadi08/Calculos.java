package tareadi08;

public class Calculos {
    public Calculos()
    {
    }
     public double suma(double op1,double op2)
    {
        double res=0.0;
        res=op1+op2;         
        return res;
    }    
    public double resta(double op1,double op2)
    {        
        double res=0.0;
        res=op1-op2;      
        return res;
    }
    public double multiplica(double op1,double op2)
    {
        
        double res=0.0;
        res=op1*op2;        
        return res;
    }
    public double divide(double op1,double op2) throws Exception
    {        
        double res=0.0;
        if (op2==0.0) 
            throw new Exception("Divide por 0 no está permitido.");           
        else
            res=op1/op2;       
        return res;
    }    
    public double exponente(double op1,double op2) throws Exception
    {
         double res=0.0;
         int op2i = (int)op2;
       
         if(op1<0.0)
         { 
            if (Math.abs(op2-Double.parseDouble(String.valueOf(op2i)))>0.0)
            {        
                //el numero es un double negativo, luego va a dar NaN
                throw new Exception("No es puede calcular con los parámetros de entrada facilitados.");
            }
         }    
         res=Math.pow(op1, op2); 
         return res;
    }
    
    public double porcentaje(double op1,double op2)
    {
         double res;
         res=op1*(op2/100);       
         return res;
    }     
    public int factorial(int numero)
    {
        int factorial=1;        
        if(numero>=0)
        {    
            for (int i=1;i<=numero;i++)        
                factorial= factorial * i;
        }else
            factorial=0;
        return factorial;
    }
    public double area(double radio)
    {
        double are=-1.0;
        if(radio>=0.0)
            are=Math.PI*(radio*radio);
        return are;
    }
    public boolean multiplos(int num1, int num2)
    {
        //asumiendo que el método comprueba si num1 es múltiplo de num2
        //El cero es múltiplo de todos los números y el único múltiplo del 0 es 0
        boolean resultado=false;
        if (num2==0)        
            resultado=true; 
        else if (num1==0 && num2!=0)
            resultado=false;
        else{            
               if (num1%num2==0)
                  resultado=true; 
        }
        return resultado;       
    }
    public double media(int[] valores) throws Exception
    {
        double med=0.0;
        //Corrección 1: debemos comprobar que el parámentro trae valores antes de calcular nada
        if (valores.length>0)
        {
        for (int i=0; i < valores.length; i++) {
             med = med + valores[i];
        }
        med = med / valores.length;
        }
        else
            throw new Exception("Media: El parámetro de entrada no tiene valores.");
        return med;
    }
   
    
}