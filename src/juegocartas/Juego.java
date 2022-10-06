package juegocartas;

import java.util.Scanner;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta la clase baraja, crea una baraja, cambia el orden de la baraja y reparte cartas a los jugadores 
***********************************************/

public class Juego  extends Baraja
{
    RegistroJugadores listaJugadores = new RegistroJugadores();
    Scanner sc = new Scanner(System.in);
    Integer[] indiceJugador;

    //**************************************************************
    
    public Juego()
    {
        
    }
    
    //**************************************************************
         
    public void registrar(int idJugador)
    { 
        String carta = repartirCarta();
        double puntosCarta= valorCartaRepartida(carta,1); 
        Jugador jugadorX = new Jugador(idJugador,puntosCarta );
        listaJugadores.addJugadoresRegistro(jugadorX);
        System.out.println("¡Hola Jugador "+idJugador+"!");
        System.out.println("Tu carta inicial es "+carta);
        System.out.println("Tus puntos iniciales son: "+ puntosCarta);
        System.out.println("");
    }
    
    //**************************************************************
    
    public double valorCartaRepartida(String cartaRepartida,int tipoMazo)
    {
        if(tipoMazo==1)
            {
                if(cartaRepartida.contains("As"))
                {
                    return 1;
                }
                else if (cartaRepartida.contains("2"))
                {
                    return 2;
                }
                else if (cartaRepartida.contains("3"))
                {
                    return 3;
                }
                else if (cartaRepartida.contains("4"))
                {
                    return 4;
                }
                else if (cartaRepartida.contains("5"))
                {
                    return 5;
                }
                else if (cartaRepartida.contains("6"))
                {
                    return 6;
                }
                else if (cartaRepartida.contains("7"))
                {
                    return 7;
                }
                else if (cartaRepartida.contains("8"))
                {
                    return 8;
                }
                else if (cartaRepartida.contains("9"))
                {
                    return 9;
                }
                
                else if (cartaRepartida.contains("10"))
                {
                    return 10;
                }
                else if (cartaRepartida.contains("J"))
                {
                    return 0.5;
                }
                else if (cartaRepartida.contains("K"))
                {
                    return 0.5;
                }
                else if (cartaRepartida.contains("Q"))
                {
                    return 0.5;
                }
                else
                {
                    return 0;
                }
            }
            else
            {
                if(cartaRepartida.contains("As"))
                {
                    return 1;
                }
                else if (cartaRepartida.contains("2"))
                {
                    return 2;
                }
                else if (cartaRepartida.contains("3"))
                {
                    return 3;
                }
                else if (cartaRepartida.contains("4"))
                {
                    return 4;
                }
                else if (cartaRepartida.contains("5"))
                {
                    return 5;
                }
                else if (cartaRepartida.contains("6"))
                {
                    return 6;
                }
                else if (cartaRepartida.contains("7"))
                {
                    return 7;
                }
                else if (cartaRepartida.contains("J"))
                {
                    return 0.5;
                }
                else if (cartaRepartida.contains("K"))
                {
                    return 0.5;
                }
                else if (cartaRepartida.contains("Q"))
                {
                    return 0.5;
                }
                else
                {
                    return 0;
                }
            }
    }
    
    //**************************************************************
    
    public String repartirCarta()
    {
        String cartaRepartida="";
        for (int i = 0; i < 1; i++)
        {
            if(i >= mazoBarajeado.size())
            {
                try
                {
                    cartaRepartida=mazoBarajeado.get(mazoBarajeado.size()-1).toString();     
                    System.out.println("BANCA REPARTE LA CARTA "+cartaRepartida);
                    mazoBarajeado.remove(mazoBarajeado.size()-1);
                }
                catch(ArrayIndexOutOfBoundsException error)
                {
                    System.out.println("Lo sientimos Cantidad de cartas insuficiente para el ultimo jugador inicia de nuevo");
                    break;
                }
            }
            else
            {
                cartaRepartida=mazoBarajeado.get(i).toString();    
                System.out.println("BANCA REPARTE LA CARTA "+cartaRepartida);
                mazoBarajeado.remove(i);
            }
        }
        return cartaRepartida;
    }
    
    //**************************************************************
    
    public double agregarCartaJugador(int idJugador, double puntosCarta)
    {
        double totalPuntos = 0;
        for (int i = 0; i <listaJugadores.registroJugadores.size(); i++)
        {
            if(listaJugadores.registroJugadores.get(i).getId()==idJugador)
            {
                double puntosAcumulados=listaJugadores.registroJugadores.get(i).getPuntos();
                totalPuntos = puntosCarta+puntosAcumulados;
                listaJugadores.registroJugadores.get(i).setPuntos(totalPuntos);
            }
        }
        return totalPuntos;
    }   
    
    //**************************************************************
    
    public Jugador ganador(int bandera){
        Jugador jugador = listaJugadores.registroJugadores.get(0);
        
        for (int i = 0; i <listaJugadores.registroJugadores.size(); i++)
        {
            if(listaJugadores.registroJugadores.get(i).getPuntos()> jugador.getPuntos()){
                jugador = listaJugadores.registroJugadores.get(i);
            }
        }
        return jugador;
    }
    
    //**************************************************************
    
    
    public void jugadores(int jugadores )
    {
        indiceJugador=new Integer[jugadores];
        for(int i = 0; i < jugadores; i++)
        {
            indiceJugador[i] = i+1;
        }
    }
    
    //**************************************************************
    
     public int turnoJugadores(int tipoMazo)
    {
        String cartaRepartida;
        boolean continuar = true;
        double valorCarta;
        int No;
        while(continuar){
            No=0;
            for (int i = 0; i < indiceJugador.length; i++)
            {
                System.out.println("");
                System.out.println("Jugador "+indiceJugador[i]+" Pedir una carta? 1=Si - 2=No");
                int pedirCarta = sc.nextInt();
                if(pedirCarta==1)
                {
                    cartaRepartida=repartirCarta();
                    valorCarta=valorCartaRepartida(cartaRepartida,tipoMazo);
                    double puntos = agregarCartaJugador((i+1),valorCarta);
                    System.out.println("Jugador "+indiceJugador[i]+" carta repartida "+cartaRepartida+" puntos de Carta "+valorCarta);
                    System.out.println("Puntos acumulados: "+puntos);
                    if(puntos== 7.5){
                        System.out.println("¡FELICIDADES JUGADOR "+indiceJugador[i]+"!");
                        System.out.println("       HAS GANADO       ");
                        return 0;
                    }
                    else if(puntos> 7.5){
                        System.out.println("Lo sentimos Jugador "+indiceJugador[i]);
                        System.out.println(" Has perdido");
                        listaJugadores.registroJugadores.remove(i);
                        return 0;
                    }
                }
                else if(pedirCarta==2)
                {
                    No +=1;
                    System.out.println("Jugador "+indiceJugador[i]+" PASO TURNO");
                }
                else
                {
                    System.out.println("Error ");
                    continuar = false;
                }
                if(No == indiceJugador.length )
                {
                    continuar = false;
                }
            }
        }
        return 0;
    }
     
}