package com.desafiojogodavelha;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JogoDaVelhaTest {

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

        for (char[] chars : tabuleiro) {
            for (int c = 0; c < tabuleiro.length; c++) {
                if (chars[c] == marcador2) {
                    contador++;
                }
            }

            if (contador == tabuleiro.length) {
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

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (char[] chars : tabuleiro) {
                if (chars[l] == marcador2) {
                    contador++;
                }
            }

            if(contador == tabuleiro.length)
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

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (int c = 0; c < tabuleiro.length; c++)
            {
                if( l == c)
                {
                    if(tabuleiro[l][c] == marcador2)
                    {
                        contador++;
                    }
                }
            }

            if(contador == tabuleiro.length)
            {
                isVencedor = true;
                break;
            }
        }

        assertTrue(isVencedor);
    }

    @Test
    public void jogoDaVelha_VerificaGanhadorDiagonalSecundaria_RetornaTrue ()
    {
        //Arrange
        var tabuleiro = mockTabuleiro();

        char marcador1 = 'X';
        char marcador2 = 'O';
        int contador = 0;
        int col;

        boolean isVencedor = false;

        for (int l = 0; l < tabuleiro.length; l++)
        {
            col = tabuleiro.length - (l+1);
            for ( int c = 0; c < tabuleiro.length ; c++)
            {
                if( tabuleiro[l][col] == marcador2)
                {
                    contador++;
                    break;
                }
            }

            if(contador == tabuleiro.length)
            {
                isVencedor = true;
                break;
            }

        }

        assertTrue(isVencedor);
    }

    public char[][] mockTabuleiro ()
    {
        return new char[][] {
                {'O', 'O','O'},
                {'X', 'O','O'},
                {'O', 'y','O'}};
    }

}