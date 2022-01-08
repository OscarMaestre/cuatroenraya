/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import io.github.conecta4.Ficha;
import io.github.conecta4.Solucion;
import io.github.conecta4.Tablero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ana
 */
public class TestTablero {
    
    public TestTablero() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public void testVerticalFila0(){
        Tablero tablero=new Tablero(8, 10);
        
        tablero.insertarFichaEnColumna(0, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(1, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(2, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        
        
        
        Solucion s=tablero.haySolucion();
        Assertions.assertNotNull(s);
        Assertions.assertEquals(3, s.getColumna0());
        Assertions.assertEquals(0, s.getFila0());
        
        Assertions.assertEquals(3, s.getColumna1());
        Assertions.assertEquals(3, s.getFila1());
        
    }
    
    public void testVerticallFila1(){
        Tablero tablero=new Tablero(8, 10);
        
        tablero.insertarFichaEnColumna(0, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(1, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        
        
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        
        
        
        Solucion s=tablero.haySolucion();
        Assertions.assertNotNull(s);
        Assertions.assertEquals(3, s.getColumna0());
        Assertions.assertEquals(1, s.getFila0());
        
        Assertions.assertEquals(3, s.getColumna1());
        Assertions.assertEquals(4, s.getFila1());
        
    }
    
    public void testHorizontalFila0(){
        Tablero tablero=new Tablero(8, 10);
        
        
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.ROJA);
        
        
        
        Solucion s=tablero.haySolucion();
        Assertions.assertNotNull(s);
        Assertions.assertEquals(0, s.getFila0());
        Assertions.assertEquals(2, s.getColumna0());
        
        Assertions.assertEquals(0, s.getFila1());
        Assertions.assertEquals(5, s.getColumna1());
        
    }
    
    public void testDiagonalDeNOhaciaSW(){
        Tablero tablero=new Tablero(8, 10);
        
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.AMARILLA);
        
        tablero.insertarFichaEnColumna(2, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(4, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(5, Ficha.ROJA);
        
        tablero.insertarFichaEnColumna(2, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.AMARILLA);
        
        tablero.insertarFichaEnColumna(2, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.ROJA);
        
        
        
        
        Solucion s=tablero.haySolucion();
        Assertions.assertNotNull(s);
        Assertions.assertEquals(0, s.getFila0());
        Assertions.assertEquals(2, s.getColumna0());
        
        Assertions.assertEquals(3, s.getFila1());
        Assertions.assertEquals(5, s.getColumna1());
        
    }
    
    public void testOtraDiagonal(){
        Tablero tablero=new Tablero(8, 10);
        
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.AMARILLA);
        
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.ROJA);
        tablero.insertarFichaEnColumna(4, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(5, Ficha.ROJA);
        
        tablero.insertarFichaEnColumna(2, Ficha.ROJA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(4, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(5, Ficha.AMARILLA);
        
        tablero.insertarFichaEnColumna(2, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(3, Ficha.AMARILLA);
        tablero.insertarFichaEnColumna(4, Ficha.ROJA);
        tablero.insertarFichaEnColumna(5, Ficha.ROJA);
        
        Solucion s=tablero.haySolucion();
        Assertions.assertNotNull(s);
        Assertions.assertEquals(0, s.getFila0());
        Assertions.assertEquals(5, s.getColumna0());
        
        Assertions.assertEquals(3, s.getFila1());
        Assertions.assertEquals(2, s.getColumna1());
        
    }
}
