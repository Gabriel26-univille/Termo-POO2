package termo;

public class WordChecker {

    public int somaArray(int[] array){
        int resultado = 0;
        for (int j : array) {
            resultado += j;
        }
        return resultado;
    }

    public int checarPalavra(String input, String resposta, int[] status) {
        int pontos = 0;

        int[][] statusResposta = {{0,0,0,0,0}, {0,0,0,0,0}};

        for(int tentativaIndex = 0; tentativaIndex < input.length(); tentativaIndex++){
            for(int respostaIndex = 0; respostaIndex < resposta.length(); respostaIndex++){

                if(input.charAt(tentativaIndex) == resposta.charAt(respostaIndex)){

                    if (statusResposta[1][respostaIndex] == 0){
                        statusResposta[1][respostaIndex] = 1;
                    }

                    if(tentativaIndex == respostaIndex && somaArray(statusResposta[1]) > somaArray(statusResposta[0])){

                        pontos += 2;
                        status[tentativaIndex] = 2;
                        statusResposta[0][tentativaIndex] = 1;
                        break;
                        
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
