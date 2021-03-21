package com.desafiojogodavelha;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JogoDaVelhaTest {

    @Test
    public void jogoDaVelha_RealizaJogada_RetornaTrue () {
        var jogoDaVelha = new JogoDaVelha(3);

        boolean actual = jogoDaVelha.realizaJogada(0,0, 'X');

        assertTrue(actual);
    }

    @Test
    public void jogoDaVelha_VerificaGanhadorNaLinha_RetornaTrue ()
    {
        //Arrange
        var tabuleiro = mockTabuleiro();

        char marcador1 = 'X';
        char marcador2 = 'O';
        int contador = 0;

        boolean isVencedor = false;
        var linhaVencedora = new boolean[tabuleiro.length];

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (int c = 0; c < tabuleiro.length; c++)
            {
                if(tabuleiro[l][c] == marcador2)
                {
                    linhaVencedora[c] = true;
                    contador++;
                }

            }

            if(contador == linhaVencedora.length)
            {
                isVencedor = true;
                break;
            }
            contador = 0;
        }

        assertTrue(isVencedor);
    }


    @Test
    public void jogoDaVelha_VerificaGanhadorNaColuna_RetornaTrue ()
    {
        //Arrange
        var tabuleiro = mockTabuleiro();

        char marcador1 = 'X';
        char marcador2 = 'O';
        int contador = 0;

        boolean isVencedor = false;
        var colunaVencedor = new boolean[tabuleiro.length];

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (int c = 0; c < tabuleiro.length; c++)
            {
                if(tabuleiro[c][l] == marcador2)
                {
                    colunaVencedor[l] = true;
                    contador++;
                }
            }

            if(contador == colunaVencedor.length)
            {
                isVencedor = true;
                break;
            }
            contador = 0;
        }

        assertTrue(isVencedor);
    }

    @Test
    public void jogoDaVelha_VerificaGanhadorDiagonal_RetornaTrue ()
    {
        //Arrange
        var tabuleiro = mockTabuleiro();

        char marcador1 = 'X';
        char marcador2 = 'O';
        int contador = 0;

        boolean isVencedor = false;
        var diagonalVencedora = new boolean[tabuleiro.length];

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (int c = 0; c < tabuleiro.length; c++)
            {
                if( l == c)
                {
                    if(tabuleiro[l][c] == marcador2)
                    {
                        diagonalVencedora[l] = true;
                        contador++;
                    }
                }
            }

            if(contador == diagonalVencedora.length)
            {
                isVencedor = true;
                break;
            }
            //contador = 0;
        }

        assertTrue(isVencedor);
    }

    public char[][] mockTabuleiro ()
    {
        return new char[][] {
                {'O', 'O','X'},
                {'X', 'O','O'},
                {'O', 'y','O'}};
    }

}