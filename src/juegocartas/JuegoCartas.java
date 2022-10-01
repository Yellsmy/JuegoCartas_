package juegocartas;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta la clase baraja, crea una baraja, cambia el orden de la baraja y reparte cartas a los jugadores 
***********************************************/

public class JuegoCartas 
{
    public static void main(String[] args) 
    {
        //Instancia de la clase baraja 
        Baraja baraja = new Baraja();
        //Creacion de la baraja
        baraja.llenarMazo();
        //Barajear cartas
        baraja.barajear();
        //Repartir cartas a jugadores
        baraja.Jugadores(3);
    }//End main

}//End clase JuegoCartas
