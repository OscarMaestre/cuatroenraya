/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.conecta4;

/**
 *
 * @author ana
 */
public class Main {
    public static void main(String[] args) {
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
        
        
        
        
        System.out.println(tablero.toStringCanonico());
        Solucion s=tablero.haySolucion();
        System.out.println(s);
        
        Tablero t=new Tablero(tablero);
        t.insertarFichaEnColumna(0, Ficha.ROJA);
        System.out.println(t.toStringCanonico());
    }
    
}
