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
    private EpisodeoVelma inicio, fin;
    private int lenght;
    
    public ColaVelma(){
        this.inicio = null;
        this.fin = null;
        this.lenght = 0;
    }
    
    public boolean estaVacio(){
        if (this.lenght == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void Insertar(EpisodeoVelma episodeo){
        if (estaVacio()) {
            this.inicio = episodeo;
            this.fin = episodeo;
        } else {
            this.fin.siguiente = episodeo;
            this.fin = episodeo;
        }
        this.lenght++;
    }
    
    public EpisodeoVelma Extraer(){
        if (!estaVacio()) {
            EpisodeoVelma episodeo = this.inicio;
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.siguiente;
            }
            this.lenght--;
            return episodeo;
        }else{
            return null;
        }
            
    }
    public int getlenght(){
        return this.lenght;
    }
    public EpisodeoVelma getInicio(){
        return this.inicio;
    }
}

