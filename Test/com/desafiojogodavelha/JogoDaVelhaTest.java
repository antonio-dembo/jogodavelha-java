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
    public void jogoDaVelha_VerificaSeTemGanhador_RetornaTrue ()
    {
        //Arrange
        var tabuleiro = mockTabuleiro();

        char marcador1 = 'X';
        char marcador2 = 'O';
        boolean state = false;
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


    public char[][] mockTabuleiro ()
    {
        return new char[][] {
                {'X', 'O','O'},
                {'O', 'y','O'},
                {'O', 'O','O'}};
    }



}