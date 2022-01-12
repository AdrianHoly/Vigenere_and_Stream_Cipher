package Vigenere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private StringBuilder text = new StringBuilder();

    public Reader(String input) throws IOException {
        String line;

        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Ado/IdeaProjects/Vigenere_&_Stream_Cipher/src/Vigenere/textfiles/" + input));
        while((line = br.readLine()) != null){
            text.append(line);
            text.append("\n");
        }
    }

    public StringBuilder getText() {
        return text;
    }
}
