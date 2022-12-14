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
    //Creamos el arreglo para la baraja ordenada
    private List<Carta> mazo = new ArrayList<Carta>();

    //Creamos el arreglo para la baraja desordenada
    List<Carta> mazoBarajeado = new ArrayList<Carta>();

    //**************************************************************
    
    // Asigna un tipo de palo al crear la carta
    public void llenarMazo(int tipoMazo)
    {
        //char puede almacenar los codigos de la tabla ascii (American-Standar-Code-Information-Interchange)
        char simboloAsciiCorazon=3;//codigo de simbolo corazon
        char simboloAsciiDiamante=4;//codigo de simbolo diamante
        char simboloAsciiTrebol=5;//codigo de simbolo trebol
        char simboloAsciiPica=6;//codigo de simbolo pica
        while (true){
            if(tipoMazo==1)// creamos las cartas segun el tipo de mazo
            {
                
                if(mazo.size() ==0)
                {
                    generarCarta("Pica",simboloAsciiPica,tipoMazo);// asignacion de palo a la genreacion de carta 
                }            
                else if(mazo.size()==13)
                {
                    generarCarta("Corazon",simboloAsciiCorazon,tipoMazo); // asignacion de palo a la genreacion de carta 
                }
                else if(mazo.size()== 26)
                {
                    generarCarta("Diamante",simboloAsciiDiamante,tipoMazo); // asignacion de palo a la genreacion de carta 
                }
                else if(mazo.size()==39)
                {
                    generarCarta("Trebol",simboloAsciiTrebol,tipoMazo); // asignacion de palo a la genreacion de carta 
                    break;
                }
            }
            else
            {
                if(mazo.size() ==0)
                {
                    generarCarta("Pica",simboloAsciiPica,tipoMazo);// asignacion de palo a la genreacion de carta 
                }            
                else if(mazo.size()==10)
                {
                    generarCarta("Corazon",simboloAsciiCorazon,tipoMazo); // asignacion de palo a la genreacion de carta 
                }
                else if(mazo.size()== 20)
                {
                    generarCarta("Diamante",simboloAsciiDiamante,tipoMazo); // asignacion de palo a la genreacion de carta 
                }
                else if(mazo.size()==30)
                {
                    generarCarta("Trebol",simboloAsciiTrebol,tipoMazo); // asignacion de palo a la genreacion de carta 
                    break;
                }
            }
        }
    }
    
    
    //**************************************************************
    
    //Crea las cartas para la baraja
    //@method addCarta asigna la carta a la baraja 
    public void generarCarta(String palo,char simboloAscii,int tipoMazo)
    {
        int contador = 1;// control para el numero de carta
            if(tipoMazo == 1) // generacion de cartas segun el tipo de mazo BARAJA COMPLETA 
            {
                for (int i = 0; i < 13; i++)
                {
                    if(contador==1)
                    {
                        addCarta(palo,simboloAscii, "As");   
                        contador+=1; 
                    }
                    else if(contador>1 && contador<=10)
                    {
                        String numeroCarta = Integer.toString(contador);
                        addCarta(palo,simboloAscii, numeroCarta);               
                        contador+=1;
                    }
                    else if(contador>10 && contador<=13)
                    {
                        addCarta(palo,simboloAscii, "J");
                        addCarta(palo,simboloAscii, "Q");
                        addCarta(palo,simboloAscii, "K");
                        contador+=3;
                    }
                }
            }
            else if (tipoMazo == 2)// generacion de cartas segun el tipo de mazo BARAJA 7 y medio 
            {
                for (int i = 0; i < 10; i++)
                {
                    if(contador==1)
                    {               
                        addCarta(palo,simboloAscii, "As");                
                        contador+=1;
                    }
                    else if(contador>1 && contador<=7)
                    { 
                        String numeroCarta = Integer.toString(contador);
                        addCarta(palo,simboloAscii, numeroCarta);               
                        contador+=1;
                    }
                    else if(contador>7 && contador<=10)
                    {
                        addCarta(palo,simboloAscii, "J");
                        addCarta(palo,simboloAscii, "Q");
                        addCarta(palo,simboloAscii, "K");
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

    //Asigna las cartas a la baraja
    public void addCarta(String palo,char simboloAscii, String identificadorCarta)
    {
        Carta c = new Carta(palo,simboloAscii, identificadorCarta);
        mazo.add(c);  //agregamos la carta 
    }
    
    
    //**************************************************************
    //Metodo para controlar cartas repetidas para crear el MAZO BARAJEADO
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
    
    // Generador de indices aleatorios para Barajear el mazo segun el tipo de mazo 
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
    //Cambiamos el orden de la baraja 
    public void barajear(int tipoMazo)
    {
        while(mazo.size() != mazoBarajeado.size())
        {
            int posicionCarta= random(tipoMazo);// recuperamos un valor aleatorio
            Carta cartaMazo1=mazo.get(posicionCarta);//obtenemos una carta al azar 
            String paloMazo1 = mazo.get(posicionCarta).getPalo();   //obtenemos identificador palo 
            String idenMazo1 = mazo.get(posicionCarta).getIdentificadorCarta();  // obtenemos numero carta 
            if(!cartasIguales(mazoBarajeado, paloMazo1,idenMazo1)) //validamos que las cartas no se repitan
            {
                mazoBarajeado.add(cartaMazo1);  //agregamos la carta en orden diferente al mazo barajeado 
            }           
        }
        System.out.println("EL MAZO HA SIDO BARAJEADO");
    } 

}

