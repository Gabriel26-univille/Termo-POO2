package termo;

public class WordChecker {

    //função de somar os elementos de um array usada na função checarPalavra
    public int somaArray(int[] array){
        int resultado = 0;
        for (int j : array) {
            resultado += j;
        }
        return resultado;
    }

    //função que checa a letra existe na resposta e se está no lugar certo
    public int checarPalavra(String input, String resposta, int[] status) {
        int pontos = 0;

        //statusResposta limita a quantidade de meio certos (amarelo) que podem aparecer em uma palavra
        //um 1 simboliza que a letra nessa posicao ja foi marcada como meio certo em algum momento
        //primeiro array se refere ao input e o segundo a resposta
        //o primeiro array nao pode ter mais meio certos que o segundo
        int[][] statusResposta = {{0,0,0,0,0}, {0,0,0,0,0}};

        for(int tentativaIndex = 0; tentativaIndex < input.length(); tentativaIndex++){
            for(int respostaIndex = 0; respostaIndex < resposta.length(); respostaIndex++){

                //se as letras comparadas sao iguais
                if(input.charAt(tentativaIndex) == resposta.charAt(respostaIndex)){

                    if (statusResposta[1][respostaIndex] == 0){
                        statusResposta[1][respostaIndex] = 1;
                    }

                    //se letra está no mesmo lugar e há espaço para mais um certo || meio certo
                    if(tentativaIndex == respostaIndex && somaArray(statusResposta[1]) > somaArray(statusResposta[0])){

                        pontos += 2;
                        status[tentativaIndex] = 2;
                        statusResposta[0][tentativaIndex] = 1;
                        break;

                        //se letra está no lugar errado e há espaço para mais um certo || meio certo
                    } else if (somaArray(statusResposta[1]) > somaArray(statusResposta[0])){

                        pontos += 1;
                        status[tentativaIndex] = 1;
                        statusResposta[0][tentativaIndex] = 1;

                    }
                }
            }
        }
        return pontos;
    }

    //função que faz print da tentativa digitada com a cor certa
    public String printPalavra(String input, int[] status){
        for(int tentativaIndex = 0; tentativaIndex < input.length(); tentativaIndex++) {
            if (status[tentativaIndex] == 2){
                System.out.print(Cores.VERDE + input.charAt(tentativaIndex));
            } else if (status[tentativaIndex] == 1){
                System.out.print(Cores.AMARELO + input.charAt(tentativaIndex));
            } else {
                System.out.print(Cores.VERMELHO + input.charAt(tentativaIndex));
            }
        }
        return(Cores.NORMAL + " ");
    }


}
