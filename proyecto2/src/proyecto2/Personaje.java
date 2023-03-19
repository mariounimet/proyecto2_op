/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Luis Domingos
 */
public class Personaje {
    private String nombre;
    private int fuerza;
    private int inteligencia;
    private int armas;
    private int velocidad;
    private int resistencia;
    private int habilidad;
    private boolean taken;
    
    public Personaje(String nombre, int fuerza, int inteligencia, int armas, int velocidad, int resistencia, int habilidad){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.habilidad = habilidad;
        this.armas = armas;
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.taken = false;
    }
    
    public void setTaken(){
        this.taken = true;
    }
    public void restartTaken(){
        this.taken = false;
    }
    public boolean isTaken(){
        return this.taken;
    }
    public int getFuerza(){
        return this.fuerza;
    }
    public int getInteligencia(){
        return this.inteligencia;
    }
    public int getAbility(){
        return this.habilidad;
    }
    public int getArmas(){
        return this.armas;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public int getResistencia(){
        return this.resistencia;
    }
    public String getNombre(){
        return this.nombre;
    }
}
