package juegocartas;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta la clase baraja, crea una baraja, cambia el orden de la baraja y reparte cartas a los jugadores 
***********************************************/
    

import java.util.Scanner;

public class JuegoCartas 
{
    Scanner op = new Scanner(System.in);
    
    //**************************************************************
    
    public void menu(int tipoMazo)
    {
        Juego jugar = new Juego();
        boolean salir = false;
        int opcion;
        while(!salir)
        {
            System.out.println("");
            System.out.println("|---------------**BIENVENIDO**-------------|"); 
            System.out.println("|          **JUEGO CARTAS 7 Y MEDIO**      |");
            System.out.println("|  1. Start                                |");
            System.out.println("|  0. Regresar                             |");
            System.out.println("| ----------Selecciona la opción---------- |");
            opcion = op.nextInt();
            op.nextLine();
            switch(opcion)
            {
                case 1:
                    //Creacion de la baraja
                    jugar.llenarMazo(tipoMazo);
                    //Barajear cartas
                    jugar.barajear(tipoMazo);
                    //Repartir cartas a jugadores;
                    System.out.println("Cuántos jugadores? ");
                    int cantidadJugadores = op.nextInt();
                    if(cantidadJugadores  >10)
                    {
                        System.out.println("Lo sentimos, la cantidad máxima de jugadores es 10");
                        salir = true;
                    }
                    else
                    {
                        op.nextLine();
                        jugar.jugadores(cantidadJugadores);
                        for (int i=0; i < cantidadJugadores; i++)
                        {
                            jugar.registrar(i+1);                   
                        }
                        int bandera = jugar.turnoJugadores(tipoMazo);
                        Jugador ganador =jugar.ganador(bandera);
                            System.out.println("FELICIDADES JUGADOR "+ganador.getId());
                            System.out.println("Has ganado con "+ganador.getPuntos()+ " puntos");
                        
                    }
                    salir = true;
                    break;
                case 0:
                    salir = true;               
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");          
            } 
        }    
    }
    
    //**************************************************************
    
    public void tipoDeJuego()
    {
        boolean salir = false;
        while(!salir){
            System.out.println("");
            System.out.println("|------------**BIENVENIDO**------------|"); 
            System.out.println("| ¿Qué tipo de juego deseas jugar?     |");
            System.out.println("|  1. 10 y medio                       |");
            System.out.println("|  2. 7 y medio                        |");
            System.out.println("|  0. SALIR                            |");
            System.out.println("| --------Selecciona la opción-------- |");
            int opcion = op.nextInt();
            op.nextLine();
            if( opcion == 0)
            {
                salir = true;
            }
            else
            {
                menu(opcion);
            }
        }
    }
    
    
    public static void main(String[] args) 
        
    {
        JuegoCartas juego = new JuegoCartas();
        juego.tipoDeJuego(); 
    }//End main

}//End clase JuegoCartas

