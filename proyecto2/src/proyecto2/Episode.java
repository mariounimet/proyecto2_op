/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author MARLON
 */
public class Episode {
    private int id;
    private int duration;
    private int calidad;
    private int waiting;
    private Episode next;
    private Episode previus;
    
    public Episode(int id, int duration, int calidad){
        this.id = id;
        this.duration = duration;
        this.calidad = calidad;
        this.waiting = 0;
        this.next = null;
        this.previus = null;
    }
    
    public void continueWaiting(){
        this.waiting += 1;
    }
    
    public void promote(){
        this.waiting = 0;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getCalidad(){
        return this.calidad;
    }
    
    public int getWaiting(){
        return this.waiting;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public Episode getNext(){
        return this.next;
    }
    
    public Episode getPrevius(){
        return this.previus;
    }
    
    public void setNext(Episode ep){
        this.next = ep;
    }
    public void setPrevius(Episode ep){
        this.previus = ep;
    }
    public void refuerzoCalidad(){
        this.calidad = 5;
    }
}
