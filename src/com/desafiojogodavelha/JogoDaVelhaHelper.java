package com.desafiojogodavelha;

public class JogoDaVelhaHelper
{
    private final char[][] _tabuleiro;

    public JogoDaVelhaHelper(char[][] tabuleiro) {
        _tabuleiro = tabuleiro;
    }

    public boolean verificarGanhadorLinha (char marcador)
    {
        int contador = 0;
        boolean isVencedor = false;

        for (char[] chars : _tabuleiro)
        {
            for (int c = 0; c < _tabuleiro.length; c++) {
                if (chars[c] == marcador) {
                    contador++;
                }
            }

            if (contador == _tabuleiro.length) {
                isVencedor = true;
                break;
            }
            contador = 0;
        }

        return isVencedor;
    }

    public boolean verificarGanhadorColuna ( char marcador)
    {
        int contador = 0;

        boolean isVencedor = false;

        for (int l = 0; l < _tabuleiro.length; l++)
        {
            for (char[] chars : _tabuleiro) {
                if (chars[l] == marcador ) {
                    contador++;
                }
            }

            if(contador == _tabuleiro.length)
            {
                isVencedor = true;
                break;
            }
            contador = 0;
        }

        return isVencedor;
    }

    public boolean verificarGanhadorDiagonal ( char marcador)
    {
        int contador = 0;
        boolean isVencedor = false;

        for (int l = 0; l < _tabuleiro.length; l++)
        {
            for (int c = 0; c < _tabuleiro.length; c++)
            {
                if( l == c)
                {
                    if(_tabuleiro[l][c] == marcador)
                    {
                        contador++;
                    }
                }
            }

            if(contador == _tabuleiro.length)
            {
                isVencedor = true;
                break;
            }
        }

        return isVencedor;
    }

    public boolean verificarGanhadorDiagonalSecundaria ( char marcador)
    {
        int contador = 0;
        int col;

        boolean isVencedor = false;

        for (int l = 0; l < _tabuleiro.length; l++)
        {
            col = _tabuleiro.length - (l+1);
            for ( int c = 0; c < _tabuleiro.length ; c++)
            {
                if( _tabuleiro[l][col] == marcador )
                {
                    contador++;
                    break;
                }
            }

            if(contador == _tabuleiro.length)
            {
                isVencedor = true;
                break;
            }
        }

        return isVencedor;
    }

}

