/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Luis Domingos
 */
public class ColaVelma {
    private VelmaNodo inicio, fin;
    
    public ColaVelma(){
        inicio = null;
        fin = null;
    }
    
    public boolean estaVacio(){
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void Insertar(int nuevoEpisodeo){
        VelmaNodo nuevo_nodo = new VelmaNodo();
        nuevo_nodo.episodeo = nuevoEpisodeo;
        nuevo_nodo.siguiente = null;
        
        if (estaVacio()) {
            inicio = nuevo_nodo;
            fin = nuevo_nodo;
        } else {
            fin.siguiente = nuevo_nodo;
            fin = nuevo_nodo;
        }
    }
    
    public int Extraer(){
        if (!estaVacio()) {
            int episodeo = inicio.episodeo;
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.siguiente;
            }
            return episodeo;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
