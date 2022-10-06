package juegocartas;
import java.util.ArrayList;
import java.util.List;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta la clase baraja, crea una baraja, cambia el orden de la baraja y reparte cartas a los jugadores 
***********************************************/

public class RegistroJugadores
{
    List<Jugador> registroJugadores = new ArrayList<Jugador>();

    //**************************************************************
    
    // Constructor vacío
    public RegistroJugadores()
    {
    }

    //**************************************************************
    
    public List<Jugador> getRegistroJugadores()
    {
        return registroJugadores;
    }

    public void setRegistroJugadores(List<Jugador> registroJugadores)
    {
        this.registroJugadores = registroJugadores;
    }
    
    //**************************************************************
    
    // Método para agregar un jugador al registro
    // @param Jugador: Recibe un jugador
    public void addJugadoresRegistro (Jugador jugador)
    {
        registroJugadores.add(jugador);
    }

    //**************************************************************
    
    // Muestra un jugador de la lista
    @Override
    public String toString()
    {
        return "RegistroJugadores{" + "registroJugadores=" + registroJugadores + '}';
    }
}
