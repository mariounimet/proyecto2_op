/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.Random;

/**
 *
 * @author MARLON
 */
public class AdminGOT{
    Queue p1 = new Queue(1);
    Queue p2 = new Queue(2);
    Queue p3 = new Queue(3);
    Queue pr = new Queue(4);
    
    private int currentId = 1;
    private int cont = 0;
    
    public void printSizes(){
        p1.printAll();
        System.out.println();
        p2.printAll();
        System.out.println();
        p3.printAll();
        System.out.println();
        System.out.println();
        
    }
    
    public void newEpisode(){

        Random rand = new Random();
        int probabilidad;
        int calidad = 0;
        int duracion;
        // intros de got
         
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 75){
            calidad++;
        }
        
        // Inicios de got
        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 84){
            calidad++;
        }
        //Cierre de got
        for(int i=0; i < 2; i++){    
            probabilidad = rand.nextInt(100)+1;
            if (probabilidad <= 84){
                calidad++;
            }
        }
        //Creditos de got

        probabilidad = rand.nextInt(100)+1;
        if (probabilidad <= 75){
            calidad++;
        }
        
        duracion = calidad*23;
        
        if (duracion > 90){
            p1.add(new Episode(currentId, duracion, calidad));
        }else if(duracion < 60){
            p3.add(new Episode(currentId, duracion, calidad));
        }else{
            p2.add(new Episode(currentId, duracion, calidad));
        }
        currentId += 1;
    }
    
    public void toBooster(Episode ep){
        ep.refuerzoCalidad();
        pr.add(ep);
    }
    
    public Episode selectToFight(){
        Random ran = new Random();
        int prob = ran.nextInt(100) + 1;
        if(cont == 2){  
            if(prob <= 70){
                newEpisode();
            }
            cont = 0;
        }
        cont++;
        if(prob <= 40 && pr.getSize() > 0){
            p1.add(pr.dequeue());
        }
        promoteEpisodes();
        if(p1.getSize() > 0){
            return p1.dequeue();
        }else if(p2.getSize() > 0){
            return p2.dequeue();
        }else if(p3.getSize() > 0){
            return p3.dequeue();
        }else{
            return null;
        }
    }
    
    private void promoteEpisodes(){
        int cont = 0;
        int size = p2.getSize();
        Episode aux = p2.getFirst();
        
        while(cont < size && aux != null){
            
            aux.continueWaiting();
            if(aux.getWaiting() == 8){
                aux.promote();
                p1.add(p2.dequeue());
            }
            
            aux = aux.getPrevius();
            cont++;
        }
        
        cont = 0;
        size = p3.getSize();
        aux = p3.getFirst();
        
        while(cont < size && aux != null){
            
            aux.continueWaiting();
            if(aux.getWaiting() == 8){
                aux.promote();
                
                p2.add(p3.dequeue());
            }
            
            aux = aux.getPrevius();
            cont++;
        }
    }
    
    public String[] queues(){
        String[] st = new String[4];
        
        st[0] = p1.getItems();
        st[1] = p2.getItems();
        st[2] = p3.getItems();
        st[3] = pr.getItems();
        
        return st;
    }
}
