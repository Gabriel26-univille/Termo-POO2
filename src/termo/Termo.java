package termo;

import java.util.Random;
import java.util.Scanner;
public class Termo {
    public static void termoRun() {
        Random rng = new Random();
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = new Dicionario();
        WordChecker wordChecker = new WordChecker();

        int[] status = {0,0,0,0,0};

        String resposta = dicionario.palavras[rng.nextInt((dicionario.palavras.length - 1) + 1)];
        String input;

        System.out.println(Cores.VERDE + "TERMO" + Cores.NORMAL);
        System.out.println("Voce tem 6 tentativas para adivinhar uma palavra de 5 letras");

        for(int i = 0; i < 6; i++)
        {
            do {
                System.out.print("palavra: ");
                input = (scanner.nextLine()).toLowerCase();
                if (input.length() != 5 || !dicionario.dicionarioCheck(input)){
                    System.out.println("palavra inválida!");
                    System.out.println();
                }
            } while(input.length() != 5 || !dicionario.dicionarioCheck(input));

            System.out.println();

            for(int j = 0; j < 5; j++)
            {
                status[j] = 0;
            }

            int pontos = wordChecker.checarPalavra(input, resposta, status);

            System.out.println("Tentativa " + (i+1) + ":");
            System.out.println(wordChecker.printPalavra(input, status));

            if (pontos == 10){
                System.out.println("\n Voce acertou!");
                break;
            } else if (i == 5){
                System.out.println("\n Voce perdeu! A palavra era " + resposta);
            }
        }
    }
}
