package com.desafiojogodavelha;

import java.util.Random;
import java.util.Scanner;

public class Principal
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Bem vindo ao jodo da velha");

        var jogoDaVelha = new JogoDaVelha(
                Teclado.leInt("Digite o tamanho do tabuleiro: ")
        );

        System.out.println("Nome do Jogador 1: ");
        Jogador jogador1 = new Jogador( scanner.nextLine());

        System.out.println("Nome do Jogador 2: ");
        Jogador jogador2 = new Jogador(scanner.nextLine());

        while (true)
        {
            jogoDaVelha.setTabuleiro();
            char jogador1Marker = 'X';
            char jogador2Marker = 'O';

            String turn = Principal.primeiroJogador();

            System.out.println(turn + " Começa!");

            boolean isGameOn = true;

            int[] posicao;

            while (isGameOn)
            {
                if (turn.equals("Jogador 1"))
                {
                    System.out.println(jogoDaVelha);
                    System.out.println(jogador1.getNome() + ": sua vez!!");
                    posicao = jogoDaVelha.escolhaDoJogador();
                    jogoDaVelha.realizaJogada( posicao[0], posicao[1], jogador1Marker);

                    if ( jogoDaVelha.verificaGanhador(jogador1Marker))
                    {
                        jogador1.setPontos(jogador1.getPontos() + 10);
                        isGameOn = false;
                    } else {
                        if(jogoDaVelha.isTabuleiroCheio())
                        {
                            System.out.println(jogoDaVelha);
                            System.out.println("Empate!!");
                            break;
                        }else{
                            turn = "jogador 2";
                        }
                    }
                }
                else {
                    System.out.println(jogoDaVelha);
                    System.out.println(jogador2.getNome()  + ": sua vez!!");
                    posicao = jogoDaVelha.escolhaDoJogador();
                    jogoDaVelha.realizaJogada( posicao[0], posicao[1], jogador2Marker);

                    if ( jogoDaVelha.verificaGanhador(jogador2Marker))
                    {
                        jogador1.setPontos(jogador2.getPontos() + 10);
                        isGameOn = false;
                    } else {
                        if(jogoDaVelha.isTabuleiroCheio())
                        {
                            System.out.println(jogoDaVelha);
                            System.out.println("Empate!!");
                            break;
                        }else{
                            turn = "Jogador 1";
                        }
                    }

                }

            }

            if (!replay())
            {

                if ( jogador1.getPontos() > jogador2.getPontos())
                {
                    System.out.println(jogoDaVelha);
                    System.out.println(jogador1);
                    System.out.println(jogador1.getNome() + " é o(a) vencedor(a) !!!");
                }
                else if ( jogador2.getPontos() > jogador1.getPontos()){
                    System.out.println(jogoDaVelha);
                    System.out.println(jogador2);
                    System.out.println(jogador2.getNome() + " é o(a) vencedor(a) !!!");
                }
                else{
                    System.out.println("O Jogo terminou empatado!!");
                }
                break;
            }

        }
    }

    static boolean replay ()
    {
        System.out.println("Quer jogar denovo? 'SIM' OU 'NAO'");
        return scanner.nextLine()
                .toLowerCase()
                .startsWith("s");
    }

    static String primeiroJogador ()
    {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return "Jogador 2";
        } else {
            return "Jogador 1";
        }
    }

}