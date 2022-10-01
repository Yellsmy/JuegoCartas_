package juegocartas;
/***********************************************
* Carta.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Metodos para asignar, obtener carta, concatenacion de identificador de carta y palo de carta
***********************************************/

public class Carta 
{
    private String palo;
    private String identificadorCarta;

    //**************************************************************
    //Metodo constructor
    public Carta(String palo, String identificadorCarta) {
        this.palo = palo;
        this.identificadorCarta = identificadorCarta;
    }

    //**************************************************************
    // Metodos getter setter de la clase cartas
    public String getPalo() 
    {
        return palo;
    }

    public void setPalo(String palo) 
    {
        this.palo = palo;
    }

    public String getIdentificadorCarta() 
    {
        return identificadorCarta;
    }

    public void setIdentificadorCarta(String identificadorCarta) 
    {
        this.identificadorCarta = identificadorCarta;
    }

    //**************************************************************
    @Override
    public String toString() 
    {
        return identificadorCarta + "-"+ palo;
    }
}
