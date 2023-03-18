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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaVelma cola1 = new ColaVelma();
        cola1.Insertar(12);
        cola1.Insertar(1);
        cola1.Insertar(2);
        cola1.Insertar(1212);
        int printear;
        printear = cola1.Extraer();
        System.out.println(printear);
        printear = cola1.Extraer();
        System.out.println(printear);
        printear = cola1.Extraer();
        System.out.println(printear);
        printear = cola1.Extraer();
        System.out.println(printear);
        
        
        
    }
    
}
