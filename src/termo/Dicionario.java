package termo;

public class Dicionario {

    //lista de palavras (manter tudo minúsculo e sem acento)
    final String[] palavras = {
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

    //checa se o input é uma palavra de verdade (que consta no array de palavras)
    public boolean dicionarioCheck(String input){
        boolean palavraValida = false;

        for (String palavra : palavras) {
            if (input.equals(palavra)) {
                palavraValida = true;
                break;
            }
        }
        return palavraValida;
    }

}
