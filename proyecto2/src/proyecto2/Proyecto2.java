/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

/**
 *
 * @author MARLON
 */
public class Proyecto2 {

    public static void main(String[] args) {

        AdminGOT admin = new AdminGOT(); 
        EpisodeoVelma ep = new EpisodeoVelma(1);
        EpisodeoVelma ep2 = new EpisodeoVelma(2);
        EpisodeoVelma ep3 = new EpisodeoVelma(3);
        EpisodeoVelma ep4 = new EpisodeoVelma(4);
        EpisodeoVelma ep5 = new EpisodeoVelma(5);
        EpisodeoVelma ep6 = new EpisodeoVelma(6);
        EpisodeoVelma ep7 = new EpisodeoVelma(7);
        int aux = ep.getDuracion();
        System.out.println(aux);
        aux = ep2.getDuracion();
        System.out.println(aux);
        aux = ep3.getDuracion();
        System.out.println(aux);
        aux = ep4.getDuracion();
        System.out.println(aux);
        aux = ep5.getDuracion();
        System.out.println(aux);
        aux = ep6.getDuracion();
        System.out.println(aux);
        aux = ep7.getDuracion();
        System.out.println(aux);
        
        
    }
    
}
