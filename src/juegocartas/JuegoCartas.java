package juegocartas;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta el método para elegir el tipo de juego el cual ejecuta 
* las funciones necesarias para jugar.
***********************************************/
    

import java.util.Scanner;

public class JuegoCartas 
{
    Scanner op = new Scanner(System.in);
    
    //**************************************************************
    
    /* Ejecuta las funciones que construyen el juego
     * @param tipoMazo: tipo de mazo que se necesita para el juego
     */
    public void jugar(int tipoMazo)
    {
        //Instancia de la clase juego
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
                    System.out.println("Cuántos jugadores? ");
                    int cantidadJugadores = op.nextInt();
                    if(cantidadJugadores > 10)
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
                        jugar.turnoJugadores(tipoMazo);
                        Jugador ganador =jugar.ganador();
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
    
    // Elección del tipo de juego que el jugador quiere jugar
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
                jugar(opcion);
            }
        }
    }
    
    //**************************************************************
    
    public static void main(String[] args)  
    {
        // Instancia de la clase JuegoCartas
        JuegoCartas juego = new JuegoCartas();
        
        // Inicio del juego
        juego.tipoDeJuego();
        
    }//End main

}//End clase JuegoCartas

