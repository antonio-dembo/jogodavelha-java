package com.desafiojogodavelha;

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
        var helper = new JogoDaVelhaHelper(tabuleiro);
        return helper.verificarGanhadorLinha(marcador) ||
                helper.verificarGanhadorColuna(marcador) ||
                helper.verificarGanhadorDiagonal(marcador) ||
                helper.verificarGanhadorDiagonalSecundaria(marcador);
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
        //int[] posicoes = posicoesValidas();

        int linha = Teclado.leInt("Escolha a linha: (0-3)");
        int coluna = Teclado.leInt("Escolha a coluna: (0-3)");

        return new int[] { linha, coluna};
    }

    public int[] posicoesValidas()
    {
        int[] posicaos = new int[tabuleiro.length];
        for (int i = 0; i < tabuleiro.length; i++) {
            posicaos[i] = i;
        }
        return posicaos;
    }


}
