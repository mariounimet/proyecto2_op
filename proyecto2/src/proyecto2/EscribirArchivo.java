/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Domingos
 */
public class EscribirArchivo {
    BufferedWriter bw = null;
    FileWriter fw = null;
    File file;
    String pathVelma = "src\\assets\\EstadisticasVelma.txt";
    String pathGot = "src\\assets\\EstadisticasGot.txt";
    String escribirGot = "";
    String escribirVelma = "";
    public EscribirArchivo(){
        
    }

    public void Escribir(EpisodeoVelma velma, Episode got) {
        try{
            if (velma == null){
                int ep = got.getId();
                String epString = String.valueOf(ep);
                escribirGot += "Salio el ep "+epString+"de Game Of Thrones\n";
                PrintWriter pw = new PrintWriter(pathGot);
                pw.print(escribirGot);
                pw.close();
            }else{
                int ep = velma.getID();
                String epString = String.valueOf(ep);
                escribirVelma += "Salio el ep "+epString+"de Velma\n";
                PrintWriter pw = new PrintWriter(pathVelma);
                pw.print(escribirVelma);
                pw.close();
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema al meter la informacion");
        }
    }
        
    
    
}
