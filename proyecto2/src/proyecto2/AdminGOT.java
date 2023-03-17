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
    Queue pr = new Queue(3);
    
    private int currentId = 0;
    
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
        Random random = new Random();
        int duration = random.nextInt(91) + 30;
        
        if (duration > 90){
            p1.add(new Episode(currentId, duration, 1));
        }else if(duration < 60){
            p3.add(new Episode(currentId, duration, 3));
        }else{
            p2.add(new Episode(currentId, duration, 2));
        }
        currentId += 1;
        printSizes();
    }
    
    public void toBooster(Episode ep){
        pr.add(ep);
    }
    
    public Episode selectToFight(){
        if(p1.getSize() > 0){
            promoteEpisodes();
            return p1.dequeue();
        }else if(p2.getSize() > 0){
            promoteEpisodes();
            return p2.dequeue();
        }else if(p3.getSize() > 0){
            promoteEpisodes();
            return p3.dequeue();
        }else{
            return null;
        }
    }
    
    private void promoteEpisodes(){
        int cont = 0;
        int size = p2.getSize();
        Episode aux = p2.getFirst();
        
        while(cont < size){
            
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
        
        while(cont < size){
            
            aux.continueWaiting();
            if(aux.getWaiting() == 8){
                aux.promote();
                
                p2.add(p3.dequeue());
            }
            
            aux = aux.getPrevius();
            cont++;
        }
    }
}
