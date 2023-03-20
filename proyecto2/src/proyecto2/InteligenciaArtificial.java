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
    
    private int lanzadosGot = 0;
    private int lanzadosVelma = 0;
    
    private AdminGOT adminGot = new AdminGOT();
    private AdministradorVelma adminVelma = new AdministradorVelma();
    
    private Episode epGot;
    private EpisodeoVelma epVelma;
    
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
        adminGot.newEpisode();
        adminVelma.newEp();
        
        String[] cg = adminGot.queues();
        String[] cv = adminVelma.queues();
        String[] colas = {
            cg[0],cg[1],cg[2],cg[3],cv[0],cv[1],cv[2],cv[3],
        };

        inter.updateQueues(colas);
        
    }
    public void simulacion(){
        while(true){
            System.out.println("empieza");
            epGot = null;
            epVelma = null;
            updateColas();
            System.out.println("update colas");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
            }
            //pedir episodios
            while(epGot == null){
                System.out.println("null de Got");
                epGot = adminGot.selectToFight();
                System.out.println(epGot);
            }
            while(epVelma == null){
                System.out.println("Null de velma");
                epVelma = adminVelma.selecPelea();
                System.out.println(epVelma);
// 
            }
            updateColas();
            System.out.println("update colas 2");
            int result = 1;
            //mostrar colas
            try {
                //iniciar pelea
                result = Pelea(epGot, epVelma);
            } catch (InterruptedException ex) {
                Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
            }
                //actualizar interfaz de pelea
            //procesar resultado
            switch (result) {
                case 0:
                    adminGot.toBooster(epGot);
                    adminVelma.Reforzar(epVelma);
                    break;
            //guardar resultado
                case 1:
                    adminGot.p1.add(epGot);
                    adminVelma.prio1.Insertar(epVelma);
                    break;
                case 2:
                    lanzadosVelma += 1;
                    break;
                default:
                    lanzadosGot += 1;
                    break;
            }
            System.out.print(lanzadosGot+"-");
            System.out.println(lanzadosVelma);
            System.out.println("\n");
        }
    }
    public void updateColas(){
        String[] cg = adminGot.queues();
        String[] cv = adminVelma.queues();
        String[] colas = {
            cg[0],cg[1],cg[2],cg[3],cv[0],cv[1],cv[2],cv[3],
        };

        inter.updateQueues(colas);
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
            if(calidadGot >= 5) {
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
            if(calidadVelma >= 5) {
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
            //PlotArmor de Morty, tiene un 50% de probilidad de ganar la batalla nada mas comenzar
            if(personajeGot.getAbility()== 1){
                int mortyAbility = rand.nextInt(100)+1;
                if(mortyAbility>=50){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                }
            }
            if(personajeVelma.getAbility() == 1){
                int mortyAbility = rand.nextInt(100)+1;
                if(mortyAbility>=50){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }
            }
            //Pelea por fuerza
            if(areaCombate == 1){
                int fuerzaVelma = personajeVelma.getFuerza();
                int fuerzaGot = personajeGot.getFuerza();
                if(personajeGot.getAbility() == 2){ //Abilidad de Rick, si se activa crea un algo para duplicar su estadistica
                    int rickAbility = rand.nextInt(100)+1;
                    if(rickAbility>=50){
                        fuerzaGot = fuerzaGot*2;
                    } 
                }
                if(personajeVelma.getAbility() == 2){
                    int rickAbility = rand.nextInt(100)+1;
                    if(rickAbility>=50){
                        fuerzaVelma = fuerzaVelma*2;
                    }
                }
                if(fuerzaVelma > fuerzaGot){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }else{
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                } 
            //Pelea por Inteligencia
            }else if(areaCombate == 2){
                int inteligenciaVelma = personajeVelma.getInteligencia();
                int inteligenciaGot = personajeGot.getInteligencia();
                if(personajeGot.getAbility() == 2){//Abilidad de Rick, si se activa crea un algo para duplicar su estadistica
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        inteligenciaGot = inteligenciaGot*2;
                    } 
                }
                if(personajeVelma.getAbility() == 2){
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        inteligenciaVelma = inteligenciaVelma*2;
                    }
                }
                if(inteligenciaVelma > inteligenciaGot){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }else{
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                }
            //pelea por armas
            }else if(areaCombate == 3){
                int armaVelma = personajeVelma.getArmas();
                int armaGot = personajeGot.getArmas();
                if(personajeGot.getAbility() == 2){//Abilidad de Rick, si se activa crea un algo para duplicar su estadistica
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        armaGot = armaGot*2;
                    } 
                }
                if(personajeVelma.getAbility() == 2){
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        armaVelma = armaVelma*2;
                    }
                }
                if(armaVelma > armaGot){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }else{
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                }
            //pelea por velocidad
            }else if(areaCombate == 4){
                int velocidadVelma = personajeVelma.getVelocidad();
                int velocidadGot = personajeGot.getVelocidad();
                if(personajeGot.getAbility() == 2){//Abilidad de Rick, si se activa crea un algo para duplicar su estadistica
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        velocidadGot = velocidadGot*2;
                    } 
                }
                if(personajeVelma.getAbility() == 2){
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        velocidadVelma = velocidadVelma*2;
                    }
                }
                if(velocidadVelma > velocidadGot){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }else{
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                }
            //pelea por Resistencia
            }else{
                int resistenciaVelma = personajeVelma.getResistencia();
                int resistenciaGot = personajeGot.getResistencia();
                if(personajeGot.getAbility() == 2){//Abilidad de Rick, si se activa crea un algo para duplicar su estadistica
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        resistenciaGot = resistenciaGot*2;
                    } 
                }
                if(personajeVelma.getAbility() == 2){
                    int rickAbility = rand.nextInt(50)+1;
                    if(rickAbility>=50){
                        resistenciaVelma = resistenciaVelma*2;
                    }
                }
                if(resistenciaVelma > resistenciaGot){
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 2; //Return 2 si velma gana
                }else{
                    personajeGot.restartTaken();
                    personajeVelma.restartTaken();
                    return 3; //Return 3 si got gana
                }
            }
        }
    }
}