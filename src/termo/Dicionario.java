package termo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dicionario {

    //lista de palavras (manter tudo minúsculo e sem acento)
    final String[] palavras = lerArquivo("resources/dictionary.txt");

        public static String[] lerArquivo(String filename) {
            List<String> lines = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File(filename));

                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }

                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return lines.toArray(new String[0]);
        }

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
