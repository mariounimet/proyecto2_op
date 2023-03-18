/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Domingos
 */
public class InteligenciaArtificial {
    private Personaje personajes[] = new Personaje[8];
    private Personaje protagonistas[] = new Personaje[2];
    
    private AdminGOT adminGot = new AdminGOT();
    private AdministradorVelma adminVelma = new AdministradorVelma();
    
    private Interface inter = new Interface();
    
    public InteligenciaArtificial(){
        protagonistas[0] = new Personaje("Morty", 3, 3, 4, 5, 9, 1);
        protagonistas[1] = new Personaje("Rick", 8, 10, 9, 8, 8, 2);
        
        personajes[0] = new Personaje("BirdPerson", 10, 6, 8, 10, 7, 0);
        personajes[1] = new Personaje("Jerry", 1, 1, 1, 1, 2, 0);
        personajes[2] = new Personaje("EvilMorty", 4, 9, 7, 6, 10, 0);
        personajes[3] = new Personaje("Meeseeks", 5, 2, 2, 3, 3, 0);
        personajes[4] = new Personaje("pickleRick", 2, 8, 6, 4, 6, 0);
        personajes[5] = new Personaje("Mr.Poopybutthole", 7, 4, 3, 4, 4, 0);
        personajes[6] = new Personaje("Tammy", 6, 7, 5, 7, 1, 0);
        personajes[7] = new Personaje("Supernova", 9, 5, 10, 9, 5, 0);
        
        inter.setVisible(true);
        
        try {
            int a = Pelea(new Episode(1, 70, 5), new EpisodeoVelma(2));
            System.out.print(a);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int Pelea(Episode got, EpisodeoVelma velma) throws InterruptedException{
        Random rand = new Random();
        int probabilidad = rand.nextInt(100)+1;
        int probPer;
        Personaje personajeGot;
        Personaje personajeVelma;
        if (probabilidad <= 33){
            return 0; //significa que necesitan refuerzo
        }else if(probabilidad <= 60){
            return 1; //significa que hubo un empate
        }else{
            int areaCombate = rand.nextInt(5)+1; //decidira en que aspecto se combatira
            int calidadGot = got.getCalidad();
            int calidadVelma = velma.getCalidad();
            //escogiendo personaje got
            if(calidadGot <= 5) {
                probPer = rand.nextInt(1);
                if(this.protagonistas[probPer].isTaken() == true){
                    if(probPer == 1){
                        personajeGot = this.protagonistas[0];
                        this.protagonistas[0].setTaken();
                    }else{
                        personajeGot = this.protagonistas[1];
                        this.protagonistas[1].setTaken();
                    }
                }else{
                    personajeGot = this.protagonistas[probPer];
                    this.protagonistas[probPer].setTaken();
                }
            }else{
                probPer = rand.nextInt(7);
                while(this.personajes[probPer].isTaken() == true){
                    probPer = rand.nextInt(7);
                }
                personajeGot = this.personajes[probPer];
            }
            //escogiendo personaje velma
            if(calidadVelma <= 5) {
                probPer = rand.nextInt(1);
                if(this.protagonistas[probPer].isTaken() == true){
                    if(probPer == 1){
                        personajeVelma = this.protagonistas[0];
                        this.protagonistas[0].setTaken();
                    }else{
                        personajeVelma = this.protagonistas[1];
                        this.protagonistas[1].setTaken();
                    }
                }else{
                    personajeVelma = this.protagonistas[probPer];
                    this.protagonistas[probPer].setTaken();
                }
            }else{
                probPer = rand.nextInt(7);
                while(this.personajes[probPer].isTaken() == true){
                    probPer = rand.nextInt(7);
                }
                personajeVelma = this.personajes[probPer];
            }
            
            //pelear
            Thread.sleep(1000);
            if(areaCombate == 1){
                if(personajeVelma.getFuerza() > personajeGot.getFuerza()){
                    return 2; //Return 2 si velma gana
                }else{
                    return 3; //Return 3 si got gana
                } 
            }else if(areaCombate == 2){
                if(personajeVelma.getInteligencia() > personajeGot.getInteligencia()){
                    return 2; //Return 2 si velma gana
                }else{
                    return 3; //Return 3 si got gana
                } 
            }else if(areaCombate == 3){
                if(personajeVelma.getArmas() > personajeGot.getArmas()){
                    return 2; //Return 2 si velma gana
                }else{
                    return 3; //Return 3 si got gana
                }
            }else if(areaCombate == 4){
                if(personajeVelma.getVelocidad() > personajeGot.getVelocidad()){
                    return 2; //Return 2 si velma gana
                }else{
                    return 3; //Return 3 si got gana
                }
            }else{
                if(personajeVelma.getResistencia() > personajeGot.getResistencia()){
                    return 2; //Return 2 si velma gana
                }else{
                    return 3; //Return 3 si got gana
                }
            }
        }
    }
}


