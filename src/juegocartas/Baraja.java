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

    public List<Carta> getMazoBarajeado() {
        return mazoBarajeado;
    }

    public void setMazoBarajeado(List<Carta> mazoBarajeado) {
        this.mazoBarajeado = mazoBarajeado;
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
    public int random(int tipoMazo)
    {
        int randomIndex = 0;
        if(tipoMazo == 1)
        {
            randomIndex = (int)(Math.random()*52);
        }
        else
        {
            randomIndex = (int)(Math.random()*40);
        }
        return randomIndex;        
    }
    
    //**************************************************************
    
    //Crea las cartas para la baraja
    public void generarCarta(String palo,int tipoMazo)
    {
        int contador = 1;
            if(tipoMazo == 1)
            {
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
            else if (tipoMazo == 2)// baraja 7ymedio
            {
                for (int i = 0; i < 10; i++)
                {
                    if(contador==1)
                    {               
                        addCarta(palo, "As");                
                        contador+=1;
                    }
                    else if(contador>1 && contador<=7)
                    { 
                        String numeroCarta = Integer.toString(contador);
                        addCarta(palo, numeroCarta);               
                        contador+=1;
                    }
                    else if(contador>7 && contador<=10)
                    {
                        addCarta(palo, "J");
                        addCarta(palo, "Q");
                        addCarta(palo, "K");
                        contador+=3;
                    }
                }
            }
            else
            {
                System.out.println("El tipo de mazo seleccionado no existe seleccione 1 para mazo completo - 2 para mazo tipo 7");
            }
    }
    
    //**************************************************************
    
    // Asigna un tipo de palo a la carta creada
    public void llenarMazo(int tipoMazo)
    {
        while (true){
            if(tipoMazo==1)
            {
                if(mazo.size() ==0)
                {
                generarCarta("Pica",tipoMazo);
                }            
                else if(mazo.size()==13)
                {
                    generarCarta("Corazón",tipoMazo); 
                }
                else if(mazo.size()== 26)
                {
                    generarCarta("Diamante",tipoMazo); 
                }
                else if(mazo.size()==39)
                {
                    generarCarta("Trébol",tipoMazo); 
                    break;
                }
            }
            else
            {
                if(mazo.size() ==0)
                {
                generarCarta("Pica",tipoMazo);
                }            
                else if(mazo.size()==10)
                {
                    generarCarta("Corazón",tipoMazo); 
                }
                else if(mazo.size()== 20)
                {
                    generarCarta("Diamante",tipoMazo); 
                }
                else if(mazo.size()==30)
                {
                    generarCarta("Trébol",tipoMazo); 
                    break;
                }
            }
        }
    }
    
    //**************************************************************
    //Metodo para controlar cartas repetidas 
    public boolean cartasIguales(List<Carta> list, String paloMazo1, String idenMazo1)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String paloMazo2 = list.get(i).getPalo();
            String idenMazo2 = list.get(i).getIdentificadorCarta();
            if( paloMazo2 == paloMazo1 && idenMazo2 == idenMazo1)
            {
                return true;
            }               
        } 
        return false;
    }
    
    //**************************************************************
    //Cambiamos el orden de la baraja 
    public void barajear(int tipoMazo)
    {
        while(mazo.size() != mazoBarajeado.size())
        {
            int posicionCarta= random(tipoMazo);
            Carta cartaMazo1=mazo.get(posicionCarta);
            String paloMazo1 = mazo.get(posicionCarta).getPalo();   
            String idenMazo1 = mazo.get(posicionCarta).getIdentificadorCarta();
            if(!cartasIguales(mazoBarajeado, paloMazo1,idenMazo1))
            {
                mazoBarajeado.add(cartaMazo1);             
            }           
        }
        System.out.println("EL MAZO HA SIDO BARAJEADO");
    } 
}

