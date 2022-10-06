package juegocartas;
import java.util.ArrayList;
import java.util.List;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta la clase baraja, crea una baraja, cambia el orden de la baraja y reparte cartas a los jugadores 
***********************************************/

public class Jugador
{
    private int id;
    private double puntos;

    //**************************************************************
    
    public Jugador(int id, double puntos)
    {
        this.id = id;
        this.puntos = puntos;
    }
    
    //**************************************************************

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getPuntos()
    {
        return puntos;
    }

    public void setPuntos(double puntos)
    {
        this.puntos = puntos;
    }

    //**************************************************************
    
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", puntos=" + puntos + '}';
    }
}