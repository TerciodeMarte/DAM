/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadi08;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class CalculosTest {
    Calculos instance = null;
    public CalculosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       instance=new Calculos();
    }
    
    @After
    public void tearDown() {
    }  
    @Test
    public void testSuma() {
        System.out.println("TestSuma");
        double op1 = 0.0;
        double op2 = 0.0;       
        double expResult = 0.0;
        double result = instance.suma(op1, op2);
        assertEquals(expResult, result, 0.0);       
    }
    
    @Test
    public void testSuma2() {
        System.out.println("TestSuma2: sumando valores double");
        double op1 = Math.PI;
        double op2 = 5.65;        
        double expResult = 8.79159265;
        double result = instance.suma(op1, op2);
        assertEquals(expResult, result, 0.00000001);       
    }
   
    @Test
    public void testResta() {
        System.out.println("TestResta:0 y 0");
        double op1 = 0.0;
        double op2 = 0.0;       
        double expResult =  0.0;
        double result = instance.resta(op1, op2);
        assertEquals(expResult, result, 0.0);        
    }
    @Test
    public void testResta2() {
        System.out.println("TestResta2: Resta double");
        double op1 = Math.PI;
        double op2 = -5.65;        
        double expResult = 8.79159265;
        double result = instance.resta(op1, op2);
        assertEquals(expResult, result, 0.00000001);        
    }
    /**
     * Test of multiplica method, of class Calculos.
     */
    @Test
    public void testMultiplica() {
        System.out.println("TestMultiplica:0 y 0");
        double op1 = 0.0;
        double op2 = 0.0;       
        double expResult = 0.0;
        double result = instance.multiplica(op1, op2);
        assertEquals(expResult, result, 0.0);
        
    }

     /**
     * Test of multiplica method, of class Calculos.
     */
    @Test
    public void testMultiplica2() {
        System.out.println("TestMultiplica:multiplica double y negativos");
        double op1 = Math.PI;
        double op2 = -2.2;       
        double expResult = -6.91150383;
        double result = instance.multiplica(op1, op2);
        assertEquals(expResult, result, 0.00000001);        
    }
    /**
     * Test of divide method, of class Calculos.
     */
    @Test
    public void testDivide() {
        System.out.println("TestDivide: 0 en divisor");
        double op1 = 0.0;
        double op2 = 0.0;        
        double expResult = 0.0;
        try{
            double result = instance.divide(op1, op2);
            assertEquals(expResult, result, 0.0);
        }catch(Exception ext)
        {
            System.out.println("TestDivide: No permitido dividir por 0");
        }
    }
     /**
     * Test of divide method, of class Calculos.
     */
    @Test
    public void testDivide2() {
        System.out.println("TestDivide2: Divide double");
        double op1 = Math.PI;
        double op2 = 5.05;       
        double expResult = 0.62209755;
        try{
            double result = instance.divide(op1, op2);
            assertEquals(expResult, result, 0.00000001);
        }catch(Exception ext)
        {
            System.out.println("TestDivide: No permitido dividir por 0");
        }
    }
    /**
     * Test of exponente method, of class Calculos.
     */
    @Test
    public void testExponente() {
        System.out.println("TestExponente: 0 y 0");
        double op1 = 0.0;
        double op2 = 0.0;       
        double expResult = 1.0;
        try{
        double result = instance.exponente(op1, op2);
        assertEquals(expResult, result, 0.0);   
        }catch(Exception ext)
        {
            System.out.println("No se puede obtener el resultado con los parámetros facilitados.");
        }
    }
    @Test
    public void testExponente2() {
        System.out.println("TestExponente: dos números double con tolerancia en el octavo decimal");
        double op1 = 0.358679;
        double op2 = 0.456789;        
        double expResult = 0.62602917;
        try{
        double result = instance.exponente(op1, op2);
        assertEquals(expResult, result, 0.00000001);  
        }catch(Exception ext)
        {
            System.out.println("No se puede obtener el resultado con los parámetros facilitados.");
        }
    }
    @Test
    public void testExponente3() {
        System.out.println("TestExponente3: dos números enteros negativos");
        double op1 = -4; 
        double op2 = -8;        
        double expResult = 0.000015258789;
        try{
        double result = instance.exponente(op1, op2);
        assertEquals(expResult, result, 0.0000001);
        }catch(Exception ext)
        {
            System.out.println("No se puede obtener el resultado con los parámetros facilitados.");
        }        
    }
    @Test
    public void testExponente4() {
        System.out.println("TestExponente4: un entero negativo a entero negativo");
        double op1 = -4.5; 
        double op2 = -8;        
        double expResult = 0.000005947026;
        try{
        double result = instance.exponente(op1, op2);
        assertEquals(expResult, result, 0.0000001); 
        }catch(Exception ext)
        {
            System.out.println("No se puede obtener el resultado con los parámetros facilitados.");
        }
    }    
    @Test
    public void testExponente5() {
        System.out.println("TestExponente5: un double negativo a double negativo");
        double op1 = -4.5; 
        double op2 = -0.5;  
        double expResult = 0.0;
        try{
        double result = instance.exponente(op1, op2);
        assertEquals(expResult, result, 0.0000001);    
        }catch(Exception ext)
        {
            System.out.println("TestExponente5: No se puede obtener el resultado con los parámetros facilitados.");
        }
    }
    
    /**
     * Test of porcentaje method, of class Calculos.
     */
    @Test
    public void testPorcentaje() {
        System.out.println("TestPorcentaje");
        double op1 = 0.0;
        double op2 = 0.0;       
        double expResult = 0.0;
        double result = instance.porcentaje(op1, op2);
        assertEquals(expResult, result, 0.0);      
    }
    @Test
    public void testPorcentaje2() {
        System.out.println("TestPorcentaje2: porcentaje de double");
        double op1 = Math.E;
        double op2 = 10.0;        
        double expResult = 0.27182818;
        double result = instance.porcentaje(op1, op2);
        assertEquals(expResult, result, 0.00000001);      
    }
    /**
     * Test of factorial method, of class Calculos.
     */
    @Test
    public void testFactorial() {
        System.out.println("TestFactorial: 0");
        int numero = 0;       
        int expResult = 1;
        int result = instance.factorial(numero);
        assertEquals(expResult, result);        
    }
    @Test
    public void testFactorial2() {
        System.out.println("TestFactorial2: Negativos");
        int numero = -3;      
        int expResult = 0;
        int result = instance.factorial(numero);
        assertEquals(expResult, result);
        System.out.println("TestFactorial2: Se ha intentado calcular el factorial de un número negativo. Hemos parametrizado el resultado esperado.");
    }    
    @Test
    public void testFactorial3() {
        System.out.println("TestFactorial3: Positivos");
        int numero = 3;        
        int expResult = 6;
        int result = instance.factorial(numero);
        assertEquals(expResult, result);
      }

    /**
     * Test of area method, of class Calculos.
     */
    @Test
    public void testArea() {
        System.out.println("TestArea: 0");
        double radio = 0.0;       
        double expResult = 0.0;
        double result = instance.area(radio);
        assertEquals(expResult, result, 0.0);
       
    }
    @Test
    public void testArea2() {
        System.out.println("TestArea2: double positivo");
        double radio = 5.2;       
        double expResult = 84.94866535;
        double result = instance.area(radio);
        assertEquals(expResult, result, 0.00000001);       
    }
@Test
    public void testArea3() {
        System.out.println("TestArea3: double negativo");
        double radio = -5.2;
        double expResult = -1.0;
        double result = instance.area(radio);
        assertEquals(expResult, result, 0.0);    
        System.out.println("TestArea3: se ha intentado calcular el área con un número negativo.");
    }
    /**
     * Test of multiplos method, of class Calculos.
     */
    @Test
    public void testMultiplos() {
        System.out.println("TestMultiplos: multiplos caso num1 0 y num2 0");
        int num1 = 0;
        int num2 = 0;
        boolean expResult = true;
        boolean result = instance.multiplos(num1, num2);
        assertEquals(expResult, result);       
    }
    @Test
    public void testMultiplos1() {
        System.out.println("TestMultiplos1: multiplos caso num1 0 y num2 no 0");
        int num1 = 0;
        int num2 = 5;
        boolean expResult = false;
        boolean result = instance.multiplos(num1, num2);
        assertEquals(expResult, result);       
    }
     @Test
    public void testMultiplos2() {
        System.out.println("TestMultiplos2: multiplos caso num1 negativo");
        int num1 = -30;
        int num2 = 5;
        boolean expResult = true;
        boolean result = instance.multiplos(num1, num2);
        assertEquals(expResult, result);       
    }
    @Test
    public void testMultiplos3() {
        System.out.println("TestMultiplos3: multiplos caso num1 negativo y num 2 negativo");
        int num1 = -30;
        int num2 = -5;
        boolean expResult = true;
        boolean result = instance.multiplos(num1, num2);
        assertEquals(expResult, result);       
    }
     @Test
    public void testMultiplos4() {
        System.out.println("TestMultiplos4: multiplos caso num1 positivo y num 2 positivo");
        int num1 = 30;
        int num2 = 5;
        boolean expResult = true;
        boolean result = instance.multiplos(num1, num2);
        assertEquals(expResult, result);       
    }
    /**
     * Test of media method, of class Calculos.
     */
    @Test
    public void testMedia()  {
        System.out.println("TestMedia: Media sin valores");
        try{
            int[] valores = null;   
            double expResult = 0;
            double result = instance.media(valores);
            assertEquals(expResult, result, 0.0);
        }catch(Exception ext)
        {
            System.out.println("TestMedia: Media sin valores:Error al calcular la media porque no recibe valores de entrada");
        }
    }
    /**
     * Test of media method, of class Calculos.
     */
    @Test
    public void testMedia2() {
        System.out.println("TestMedia2: Media de 0");
        try{
        int[] valores = {0}; 
        double expResult = 0;
        double result = instance.media(valores);
        assertEquals(expResult, result, 0.0);
        }catch(Exception ext)
        {
            System.out.println("TestMedia2: Media de 0:Error al calcular la media porque no recibe valores de entrada");
        }
    }
    /**
     * Test of media method, of class Calculos.
     */
    @Test
    public void testMedia3() {
        System.out.println("TestMedia: Media con valores");
        try{
            int[] valores = {10,-5,-12,20}; 
            double expResult = 3.25;
            double result = instance.media(valores);
            assertEquals(expResult, result, 0.0);
         }catch(Exception ext)
        {
            System.out.println("TestMedia3: Media con valores:Error al calcular la media porque no recibe valores de entrada");
        }
    }
    
}
