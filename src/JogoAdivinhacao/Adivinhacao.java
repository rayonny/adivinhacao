package JogoAdivinhacao;

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {

    public static void main(String[] args) {
        Adivinhacao adivinhacao = new Adivinhacao();
        adivinhacao.inicializar();
    }

    private void inicializar() {
        try (
                Scanner scanner = new Scanner(System.in)
        ) {

            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite sua idade: ");
            int idade = Integer.parseInt(scanner.nextLine());


            usuario usuario = new usuario(nome, idade);


            int nivel = 1;
            if (idade >= 12) {
                nivel = 2;
            }


            int numero = new Random().nextInt(nivel == 1 ? 10 : 1000) + 1;


            int tentativas = 0;
            while (tentativas <= 4) {

                System.out.print("Tentativa " + (tentativas + 1) + ": ");
                int palpite = scanner.nextInt();


                if (palpite == numero) {

                    System.out.println("Parabéns, " + usuario.getNome() + "! Você Acertou o Número Sorteado! Vamos jogar Novamente?");
                    return;
                } else {

                    System.out.println("Desculpe " + usuario.getNome() + "! Numero Incorreto, Escolha outro Numero.");
                }

                tentativas++;
            }


            System.out.println("Infelismente Você Não Acertou o  Número Sorteado  Vamos Jogar NOVAMENTE?. (O Número Sorteado Era) " + numero);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


