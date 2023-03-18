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
    int contador;
    int ID;
    int duracion;
    int calidad; //contador de cosas buenas
    
    public EpisodeoVelma(int NumeroEP){
        ID = NumeroEP;
        contador = 0;
        calidad = 0;
        Random rand = new Random();
        int probabilidad;
        // intros de Velma
        for(int i=0; i < 2; i++){
            probabilidad = rand.nextInt(100)+1;
            if (probabilidad <= 75){
                calidad++;
            }
        }
        // Inicios de Velma
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 84){
            calidad++;
        }
        //Cierre de velma
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 84){
            calidad++;
        }
        //Creditos de velma
        for(int i=0; i < 2; i++){
            probabilidad = rand.nextInt(100)+1;
            if (probabilidad <= 75){
                calidad++;
            }
        }
        // Como Velma consta de 6 componentes y 90/6=15, entonces por componente correcto se le sumara 15 min a la duración del episodeo
        duracion = calidad*15;   
        
    }
}
