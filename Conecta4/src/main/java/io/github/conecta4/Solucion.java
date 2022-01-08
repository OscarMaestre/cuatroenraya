/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.conecta4;

/**
 *
 * @author ana
 */
public class Solucion {
    Ficha ficha;
    int col0, fila0, col1, fila1;

    public Solucion(Ficha ficha, int x0, int y0, int x1, int y1) {
        this.ficha = ficha;
        this.col0 = x0;
        this.fila0 = y0;
        this.col1 = x1;
        this.fila1 = y1;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public int getColumna0() {
        return col0;
    }

    public int getFila0() {
        return fila0;
    }

    public int getColumna1() {
        return col1;
    }

    public int getFila1() {
        return fila1;
    }
    

    @Override
    public String toString() {
        return "Solucion{" + "ficha=" + ficha + ", x0=" + col0 + ", y0=" + fila0 + ", x1=" + col1 + ", y1=" + fila1 + '}';
    }
}
