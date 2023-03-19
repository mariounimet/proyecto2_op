/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.Random;

/**
 *
 * @author Luis Domingos
 */
public class EpisodeoVelma {
    private int contador;
    private int ID;
    private int duracion;
    private int calidad; //contador de cosas buenas
    private EpisodeoVelma siguiente;
    
    public EpisodeoVelma(int NumeroEP){
        this.siguiente = null;
        this.ID = NumeroEP;
        this.contador = 0;
        this.calidad = 0;
        Random rand = new Random();
        int probabilidad;
        // intros de Velma
        for(int i=0; i < 2; i++){   
            probabilidad = rand.nextInt(100)+1;
            if (probabilidad <= 75){
                this.calidad++;
            }
        }
        // Inicios de Velma
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 84){
            this.calidad++;
        }
        //Cierre de velma
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 84){
            this.calidad++;
        }
        //Creditos de velma
        for(int i=0; i < 2; i++){
            probabilidad = rand.nextInt(100)+1;
            if (probabilidad <= 75){
                this.calidad++;
            }
        }
        // Como Velma consta de 6 componentes se considerara un buen ep si consigue 5 componentes buenos, es decir que se colocara en la prio1
        // Entonces se dividio 90/5 = 18, entonces por componente bueno se le sumara 18 min a la duración.
        this.duracion = this.calidad*18;   
        
    }
    
    public int getID(){
        return this.ID;
    }
    public int getContador(){
        return this.contador;
    }
    public void AumentarContador(){
        this.contador++;
    }
    public void ReiniciarContador(){
        this.contador = 0;
    }
    public int getCalidad(){
        return this.calidad;
    }
    public void refuerzoCalidad(){
        this.calidad = 6;
    }
    public int getDuracion(){
        return this.duracion;
    }
    public EpisodeoVelma getSiguiente(){
        return this.siguiente;
    }
    public void setSiguiente(EpisodeoVelma siguiente){
        this.siguiente = siguiente;
    }
}
