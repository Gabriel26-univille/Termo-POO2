package termo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //lista de palavras (manter tudo minúsculo e sem acento)
    static final String[] palavras = {
            "fazer",
            "assim",
            "vigor",
            "sutil",
            "aquem",
            "porem",
            "seçao",
            "fosse",
            "sanar",
            "poder"
    };

    //definir cores
    static final String NORMAL = "\u001B[0m";
    static final String AMARELO = "\u001B[43m";
    static final String VERDE = "\u001B[42m";
    static final String VERMELHO = "\u001B[41m";

    //função que checa a letra existe na resposta e se está no lugar certo
    public static int checarPalavra(String input, String resposta, int[] status) {
        int pontos = 0;

        for(int tentativaIndex = 0; tentativaIndex < input.length(); tentativaIndex++){
            for(int respostaIndex = 0; respostaIndex < resposta.length(); respostaIndex++){

                if(input.charAt(tentativaIndex) == resposta.charAt(respostaIndex)){
                    if(tentativaIndex == respostaIndex){
                        pontos += 1;
                        status[tentativaIndex] = 2;
                        break;
                    } else {
                        status[tentativaIndex] = 1;
                    }
                }
            }
        }
        return pontos;
    }

    //função que faz print da tentativa digitada com a cor certa
    public static void printPalavra(String input, int[] status){
        for(int tentativaIndex = 0; tentativaIndex < input.length(); tentativaIndex++) {
            if (status[tentativaIndex] == 2){
                System.out.print(VERDE + input.charAt(tentativaIndex));
            } else if (status[tentativaIndex] == 1){
                System.out.print(AMARELO + input.charAt(tentativaIndex));
            } else {
                System.out.print(VERMELHO + input.charAt(tentativaIndex));
            }
        }
        System.out.println(NORMAL + " ");
    }

    public static void main(String[] args) {

        Random rng = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean venceu = false;

        //array para armazenar pontuação de cada tentativa (0 = não na palavra, 1 = na palavra, 2 = no lugar)
        int[] status = {0,0,0,0,0};

        //escolher palavra aleatória da lista para ser a resposta
        int tamanhoLista = palavras.length - 1;
        String resposta = palavras[rng.nextInt(tamanhoLista + 1)];

        System.out.println(VERDE + "TERMO" + NORMAL);
        System.out.println("Voce tem 6 tentativas para adivinhar uma palavra de 5 letras");

        String input;

        //loop principal do jogo
        for(int i = 0; i < 6; i++)
        {
            //pedir input de palavra com 5 letras
            do {
                System.out.print("palavra: ");
                input = scanner.nextLine();
            } while(input.length() != 5);
            input = input.toLowerCase();
            System.out.println(" ");

            //limpar array de pontuação
            for(int j = 0; j < 5; j++)
            {
                status[j] = 0;
            }

            //verificar se as letras do input existem na resposta e atribuir pontos
            int pontos = checarPalavra(input, resposta, status);

            //fazer print da tentativa relacionando cores aos pontos
            System.out.println("Tentativa " + (i+1) + ":");
            printPalavra(input, status);

            //terminar jogo se input tem pontuação máxima (todas as letras no lugar certo)
            if (pontos == 5){
                venceu = true;
                break;
            }
        }

        if (venceu){
            System.out.println("Voce acertou!");
        } else {
            System.out.println("Voce perdeu! A palavra era " + resposta);
        }
    }
}


