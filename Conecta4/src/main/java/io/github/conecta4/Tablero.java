/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.conecta4;

/**
 *
 * @author ana
 */
public class Tablero {
    int FILAS;
    int COLUMNAS;
    Ficha[][] fichas;
    
    
    public Tablero(int FILAS, int COLUMNAS) {
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        fichas=new Ficha[this.FILAS][this.COLUMNAS];
        for (int i = 0; i < this.FILAS; i++) {
            for (int j = 0; j < this.COLUMNAS; j++) {
                fichas[i][j]=Ficha.VACIA;
            } //Fin del for interno            
        } //Fin del for externo
    }
    
    /* Constructor de copia*/
    public Tablero(Tablero tablero){
        this.FILAS=tablero.FILAS;
        this.COLUMNAS=tablero.COLUMNAS;
        fichas=new Ficha[this.FILAS][this.COLUMNAS];
        for (int i = 0; i < this.FILAS; i++) {
            for (int j = 0; j < this.COLUMNAS; j++) {
                fichas[i][j]=tablero.fichas[i][j];
            } //Fin del for interno            
        } //Fin del for externo
    }

    public boolean columnaEstaLlena(int columna){
        for (int i = 0; i < this.FILAS; i++) {
            if (fichas[i][columna]==Ficha.VACIA){
                return false;
            }
        }
        //Si llegamos aquí es que la columna sí está llena
        return true;
    }
    public boolean tableroEstaLleno(){
        /*Recorremos todas las columnas, y si alguna
        no está llena, es que el tablero no lo está */
        for (int col=0; col<this.COLUMNAS; col++){
            if (! columnaEstaLlena(col)){
                return false;
            }
        }
        /* Si recorremos todas las columnas y no hay
        ninguna que no estuviera llena, es que el tablero
        sí está lleno */
        return true;
    }
    public void insertarFichaEnColumna(int columna, Ficha ficha){
        for (int i=0; i<this.FILAS; i++){
            if (this.fichas[i][columna]==Ficha.VACIA){
                this.fichas[i][columna]=ficha;
                return ;
            }
        }
        /* Si llegamos aquí es porque esa columna está llena*/
    }
    
    public Solucion haySolucionVertical(int f0, int c0){
        Ficha fichaActual;
        fichaActual=fichas[f0][c0];
        if (f0+3>=this.FILAS) return null;
        Ficha ficha1=fichas[f0+1][c0];
        Ficha ficha2=fichas[f0+2][c0];
        Ficha ficha3=fichas[f0+3][c0];
        
        if ( (ficha1==ficha2) && (ficha2==ficha3) && (ficha3==fichaActual) ){
            return new Solucion (fichaActual, c0, f0, c0, f0+3);
        }
        return null;
    }
    
    public Solucion haySolucionHorizontal(int f0, int c0){
        Ficha fichaActual;
        fichaActual=fichas[f0][c0];
        if (c0+3>=this.COLUMNAS) return null;
        Ficha ficha1=fichas[f0][c0+1];
        Ficha ficha2=fichas[f0][c0+2];
        Ficha ficha3=fichas[f0][c0+3];
        //System.out.println(fichaActual+" "+ficha1+" "+ficha2+" "+ficha3+" ");
        if ( (ficha1==ficha2) && (ficha2==ficha3) && (ficha3==fichaActual) ){
            System.out.println("Solucion encontrada");
            return new Solucion (fichaActual, c0, f0, c0+3, f0);
        }
        return null;
    }
    
    public Solucion haySolucionDiagonalNOhaciaSE(int f0, int c0){
        Ficha fichaActual;
        fichaActual=fichas[f0][c0];
        if (c0+3>=this.COLUMNAS) return null;
        if (f0+3>=this.FILAS) return null;
        
        Ficha ficha1=fichas[f0+1][c0+1];
        Ficha ficha2=fichas[f0+2][c0+2];
        Ficha ficha3=fichas[f0+3][c0+3];
        //System.out.println(fichaActual+" "+ficha1+" "+ficha2+" "+ficha3+" ");
        if ( (ficha1==ficha2) && (ficha2==ficha3) && (ficha3==fichaActual) ){
            System.out.println("Solucion encontrada");
            return new Solucion (fichaActual, c0, f0, c0+3, f0+3);
        }
        return null;
    }
    
    public Solucion haySolucionDiagonalNEhaciaSO(int f0, int c0){
        Ficha fichaActual;
        fichaActual=fichas[f0][c0];
        if (c0<3) return null;
        if (f0+3>=this.FILAS) return null;
        
        Ficha ficha1=fichas[f0+1][c0-1];
        Ficha ficha2=fichas[f0+2][c0-2];
        Ficha ficha3=fichas[f0+3][c0-3];
        //System.out.println(fichaActual+" "+ficha1+" "+ficha2+" "+ficha3+" ");
        if ( (ficha1==ficha2) && (ficha2==ficha3) && (ficha3==fichaActual) ){
            System.out.println("Solucion encontrada");
            return new Solucion (fichaActual, c0, f0, c0-3, f0+3);
        }
        return null;
    }
    
    
    public Solucion haySolucion(){
        Solucion solHorizontal, solVertical,solDiagonal1, solDiagonal2;
        for (int i = 0; i < this.FILAS; i++) {
            for (int j = 0; j < this.COLUMNAS; j++) {
                //System.out.print("("+i+","+j+") "+fichas[i][j]);
                if (fichas[i][j]==Ficha.VACIA)
                        continue;
                solHorizontal=this.haySolucionHorizontal(i, j);
                if (solHorizontal!=null) return solHorizontal;
                
                solVertical=this.haySolucionVertical(i, j);
                if (solVertical!=null) return solVertical;
                
                solDiagonal1=this.haySolucionDiagonalNEhaciaSO(i, j);
                if (solDiagonal1!=null) return solDiagonal1;
                
                solDiagonal2=this.haySolucionDiagonalNOhaciaSE(i, j);
                if (solDiagonal2!=null) return solDiagonal2;
                
                
                
            } //Fin del for interno            
            System.out.println("");
        } //Fin del for externo
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i = this.FILAS-1; i>=0; i--) {
            for (int j = 0; j<this.COLUMNAS; j++) {
                if (fichas[i][j]==Ficha.VACIA){
                    sb.append("-");
                }
                if (fichas[i][j]==Ficha.AMARILLA){
                    sb.append("A");
                }
                if (fichas[i][j]==Ficha.ROJA){
                    sb.append("R");
                }
            } //Fin del for interno
            sb.append("\n");
        } //Fin del for externo
        return sb.toString();
    }
    
    public String toStringCanonico(){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i<this.FILAS; i++) {
            for (int j = 0; j<this.COLUMNAS; j++) {
                if (fichas[i][j]==Ficha.VACIA){
                    sb.append("-");
                }
                if (fichas[i][j]==Ficha.AMARILLA){
                    sb.append("A");
                }
                if (fichas[i][j]==Ficha.ROJA){
                    sb.append("R");
                }
            } //Fin del for interno
            sb.append("\n");
        } //Fin del for externo
        return sb.toString();
    }
}
