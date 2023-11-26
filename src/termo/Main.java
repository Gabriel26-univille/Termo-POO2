package termo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rng = new Random();
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = new Dicionario();
        WordChecker wordChecker = new WordChecker();

        //array para armazenar pontuação de cada tentativa (0 = não na palavra, 1 = na palavra, 2 = no lugar)
        int[] status = {0,0,0,0,0};

        //escolher palavra aleatória da lista para ser a resposta
        String resposta = dicionario.palavras[rng.nextInt((dicionario.palavras.length - 1) + 1)];

        System.out.println(Cores.VERDE + "TERMO" + Cores.NORMAL);
        System.out.println("Voce tem 6 tentativas para adivinhar uma palavra de 5 letras");

        String input;

        //loop principal do jogo
        for(int i = 0; i < 6; i++)
        {
            //pedir input de palavra com 5 letras
            do {
                System.out.print("palavra: ");
                input = (scanner.nextLine()).toLowerCase();
                if (input.length() != 5 || !dicionario.dicionarioCheck(input)){
                    System.out.println("palavra inválida!");
                    System.out.println();
                }
            } while(input.length() != 5 || !dicionario.dicionarioCheck(input));

            System.out.println();

            //limpar array de pontuação
            for(int j = 0; j < 5; j++)
            {
                status[j] = 0;
            }

            //verificar se as letras do input existem na resposta e atribuir pontos
            int pontos = wordChecker.checarPalavra(input, resposta, status);

            //fazer print da tentativa relacionando cores aos pontos
            System.out.println("Tentativa " + (i+1) + ":");
            System.out.println(wordChecker.printPalavra(input, status));

            //terminar jogo se input tem pontuação máxima (todas as letras no lugar certo)
            if (pontos == 10){
                System.out.println("\n Voce acertou!");
                break;
            } else if (i == 5){
                System.out.println("\n Voce perdeu! A palavra era " + resposta);
            }
        }
    }
}


