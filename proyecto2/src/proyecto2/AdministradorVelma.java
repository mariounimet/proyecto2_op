/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Luis Domingos
 */
public class AdministradorVelma {
    ColaVelma prio1 = new ColaVelma();
    ColaVelma prio2 = new ColaVelma();
    ColaVelma prio3 = new ColaVelma();
    ColaVelma refuerzo = new ColaVelma();
    private int epNum = 0;
    
    private void newEp(){
        this.epNum++;
        int numeroEp = this.epNum;
        EpisodeoVelma ep = new EpisodeoVelma(numeroEp);
        int duracion = ep.getDuracion();
        if (duracion >= 90){
            prio1.Insertar(ep);
        }else if(duracion >= 60){
            prio2.Insertar(ep);
        }else{
            prio3.Insertar(ep);
        }
    }
    public EpisodeoVelma selecPelea(){
        EpisodeoVelma aux = null;
        if(prio1.getlenght() > 0){
            aux = prio1.Extraer();
        }else if(prio2.getlenght() > 0){
            aux = prio2.Extraer();
        }else if(prio3.getlenght() > 0){
            aux = prio3.Extraer();
        }
        promoteEpisodes();
        return aux;
    }
    private void promoteEpisodes(){
        int contador = 0;
        int lenght = prio2.getlenght();
        EpisodeoVelma aux = prio2.getInicio();
        
        while(contador < lenght){
            aux.AumentarContador();
            if (aux.getContador() == 8){
                aux = prio2.Extraer();
                aux.ReiniciarContador();
                prio1.Insertar(aux);
            }else{
                aux.AumentarContador();
            }
            aux = aux.getSiguiente();
            contador++;
        }
        contador = 0;
        lenght = prio3.getlenght();
        aux = prio3.getInicio();
        
        while(contador < lenght){
            aux.AumentarContador();
            if (aux.getContador() == 8){
                aux = prio3.Extraer();
                aux.ReiniciarContador();
                prio2.Insertar(aux);
            }else{
                aux.AumentarContador();
            }
            aux = aux.getSiguiente();
            contador++;
        }
    }
}
