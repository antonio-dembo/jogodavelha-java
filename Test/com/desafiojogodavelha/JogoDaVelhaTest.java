package com.desafiojogodavelha;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        boolean isVencedor = false;
        var verificaLinha = new boolean[tabuleiro.length];

        for (int l = 0; l < tabuleiro.length; l++)
        {
            for (int c = 0; c < tabuleiro.length; c++) {
                verificaLinha[c] = tabuleiro[l][c] == marcador2;
            }


            for (int i = 0; i < verificaLinha.length ; i++)
            {
                if(verificaLinha[i]) {
                    if (verificaLinha.length - 1 == i) {
                        isVencedor = true;
                        break;
                    }
                }
            }

        }

        assertTrue(isVencedor);

    }


    public char[][] mockTabuleiro ()
    {
        return new char[][] {
                {'X', 'X','X'},
                {'Y', 'O','Y'},
                {'O', 'O','O'}};
    }



}