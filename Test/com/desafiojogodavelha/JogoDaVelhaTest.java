package com.desafiojogodavelha;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogoDaVelhaTest {

    @Test
    void JogoDaVelha_RealizaJogada_RetornaTrue () {
        var jogoDaVelha = new JogoDaVelha(3);

        boolean actual = jogoDaVelha.realizaJogada(0,0, 'X');

        assertTrue(actual);
    }


}