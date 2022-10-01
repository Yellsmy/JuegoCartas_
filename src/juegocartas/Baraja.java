package juegocartas;
/***********************************************
* Baraja.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Metodos para controlar la creacion de cartas, la creacion de baraja, 
* orden de la baraja, creacion de jugadores, repartir cartas
***********************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Baraja 
{
    //Creamos la baraja ordenada
    private List<Carta> mazo = new ArrayList<Carta>();

    //Creamos la baraja desordenada
    List<Carta> mazoBarajeado = new ArrayList<Carta>();

    //**************************************************************

    //Devuelve el listado de cartas de la barja ordenada
    public List<Carta> getMazo()
    {
        return mazo;
    }

    //**************************************************************

    //Asigna las cartas a la baraja
    public void addCarta(String palo, String identificadorCarta)
    {
        Carta c = new Carta(palo, identificadorCarta);
        mazo.add(c);      
    }
    
    //**************************************************************
    // Generador de indices aleatorios para Barajear el mazo
    public int random()
    {
        int randomIndex = (int)(Math.random()*52);
        return randomIndex;        
    }
    
    //**************************************************************
    //Crea las cartas para la baraja
    public void generarCarta(String palo)
    {
        int contador = 1;
        for (int i = 0; i < 13; i++)
        {
            if(contador==1)
            {               
                addCarta(palo, "As");                
                contador+=1;                
            }            
            else if(contador>1 && contador<=10)
            {                 
                String numeroCarta = Integer.toString(contador);
                addCarta(palo, numeroCarta);               
                contador+=1;                
            }
            else if(contador>10 && contador<=13)
            {
                addCarta(palo, "J");
                addCarta(palo, "Q");
                addCarta(palo, "K");
                contador+=3;
            }
        }
    }
    
    //**************************************************************
    // Asigna un tipo de palo a la carta creada
    public void llenarMazo()
    {
        while (true){
            if(mazo.size() ==0)
            {
            generarCarta("Picas");
            }            
            else if(mazo.size()==13)
            {
                generarCarta("Corazón"); 
            }
            else if(mazo.size()== 26)
            {
                generarCarta("Diamante"); 
            }
            else if(mazo.size()==39)
            {
                generarCarta("Trébol"); 
                break;
            }
        }

    }
    
    //**************************************************************
    //Metodo para controlar cartas repetidas 
    public boolean cartasIguales(List<Carta> list, String paloMazo1, String idenMazo1 )
    {
        for (int i = 0; i < list.size(); i++)
        {
            String paloMazo2 = list.get(i).getPalo();
            String idenMazo2 = list.get(i).getIdentificadorCarta();
            if( paloMazo2 == paloMazo1 && idenMazo2 == idenMazo1){
                return true;
            }               
        } 
        return false;
    }
    
    //**************************************************************
    //Cambiamos el orden de la baraja 
    public void barajear()
    {
        
        while(mazo.size() != mazoBarajeado.size())
        {
            int posicionCarta= random();
            Carta cartaMazo1=mazo.get(posicionCarta);
            String paloMazo1 = mazo.get(posicionCarta).getPalo();   
            String idenMazo1 = mazo.get(posicionCarta).getIdentificadorCarta();
            if(!cartasIguales(mazoBarajeado, paloMazo1,idenMazo1 ))
            {
                mazoBarajeado.add(cartaMazo1);             
            }           
        }
        System.out.println("MAZO BARAJEADO");

    }    

    //Asignamos cartas a un jugador
    public TreeSet<String> repartirCarta(int jugador)
    {
        System.out.println("CARTAS JUGADOR "+ (jugador+1));
        TreeSet<String> lista = new TreeSet<String>();

        for (int i = 0; i < 5; i++)
        {
            if(i >= mazoBarajeado.size())
            {
                try
                {
                    lista.add(mazoBarajeado.get(mazoBarajeado.size()-1).toString());     
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
                lista.add(mazoBarajeado.get(i).toString());     
                mazoBarajeado.remove(i);
            }
        }
        return lista;
    }    

    //Creamos el numero de jugadores y repartimos cartas
    public void Jugadores(int jugadores )
    {
        System.out.println("CANTIDAD DE JUGADORES "+jugadores);
        for (int i = 0; i < jugadores; i++)
        {
            System.out.println(repartirCarta(i));
        }
    }   

}
