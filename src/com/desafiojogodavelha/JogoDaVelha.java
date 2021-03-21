package com.desafiojogodavelha;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class JogoDaVelha
{
    private final char[][] tabuleiro;

    public JogoDaVelha (int dim)
    {
        tabuleiro = new char[dim][dim];
    }

    public boolean realizaJogada (int l, int c, char jogada)
    {
        if( isEspacoLivre(l,c) )
        {
            tabuleiro[l][c] = jogada;
            return false;
        }
        return true;
    }

    public boolean isEspacoLivre (int l, int c)
    {
        return tabuleiro[l][c] == ' ';
    }

    public boolean isTabuleiroCheio () {
        for ( int l = 0 ; l < tabuleiro.length ; l++)
        {
            for ( int c = 0 ; c < tabuleiro.length ; c++)
            {
                if(isEspacoLivre(l,c))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verificaGanhador (char marcador)
    {
        return (tabuleiro[0][0] == marcador && tabuleiro[0][1] == marcador && tabuleiro[0][2] == marcador) || // verifica primeira linha
                (tabuleiro[1][0] == marcador && tabuleiro[1][1] == marcador && tabuleiro[1][2] == marcador) || // verifica segunda linha
                (tabuleiro[2][0] == marcador && tabuleiro[2][1] == marcador && tabuleiro[2][2] == marcador) || // verifica terceira linha

                (tabuleiro[0][0] == marcador && tabuleiro[1][0] == marcador && tabuleiro[2][0] == marcador) || // verifica primeira coluna
                (tabuleiro[0][1] == marcador && tabuleiro[1][1] == marcador && tabuleiro[2][1] == marcador) || // verifica segunda coluna
                (tabuleiro[0][2] == marcador && tabuleiro[1][2] == marcador && tabuleiro[2][2] == marcador) ||  // verifica terceira coluna

                (tabuleiro[0][0] == marcador && tabuleiro[1][1] == marcador && tabuleiro[2][2] == marcador) ||  // verifica diagonal principal
                (tabuleiro[0][2] == marcador && tabuleiro[1][1] == marcador && tabuleiro[2][0] == marcador); //  verifica diagonal secundária
    }

    public void setTabuleiro() {
        for ( int l = 0 ; l < tabuleiro.length ; l++)
        {
            for ( int c = 0 ; c < tabuleiro.length ; c++)
            {
                tabuleiro[l][c] = ' ';
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder resultado= new StringBuilder();

        for ( var item : tabuleiro) {
            for ( var value : item )
            {
                resultado.append(value).append(" | ");
            }
            resultado.append("\n");
        }

        return resultado.toString();
    }

    public int[] escolhaDoJogador()
    {
        int[] posicaosValida = new int[] { 0, 1, 3};

        int linha = Teclado.leInt("Escolha a linha: (0-3)");
        int coluna = Teclado.leInt("Escolha a coluna: (0-3)");

        return new int[] { linha, coluna};
    }
}
