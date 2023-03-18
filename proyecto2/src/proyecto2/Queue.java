/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author MARLON
 */
public class Queue {
    private Episode first;
    private Episode last;
    private int priority;
    private int size;
    
    public Queue(int priority){
        this.first = null;
        this.last = null;
        this.priority = priority;
        this.size = 0;
    }
    
    public void add(Episode ep){
        if(this.size == 0){
            this.first = ep;
            this.last = ep;
        }else{
            this.last.setPrevius(ep);
            ep.setNext(this.last);
            this.last = ep;
        }
        this.size += 1;
    }
    
    public Episode dequeue(){
        Episode ep = this.first;
        if(size == 1){
            this.first = null;
            this.last = null;
        }else{
            this.first = this.first.getPrevius();
            this.first.setNext(null);
        }
        
        this.size -= 1;
        return ep;
    }
    
    public Episode getFirst(){
        return this.first;
    }
    
    public Episode getLast(){
        return this.last;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getPriority(){
        return this.priority;
    }
    
    public void printAll(){
        Episode aux = this.first;
        while(aux != null){
            System.out.print(aux.getId()+"-");
            aux = aux.getPrevius();
        }
    }
}
