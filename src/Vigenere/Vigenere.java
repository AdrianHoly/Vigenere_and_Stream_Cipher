package Vigenere;

import java.io.IOException;

public class Vigenere {
    private Decipher decipher;

    public Vigenere(String input_text, char a) throws IOException {
        Reader reader = new Reader(input_text);
        if (a=='D'){
            TextNoSpaces noSpaces = new TextNoSpaces(reader.getText());
            KeyGenerator keyGen = new KeyGenerator(noSpaces.getSb());
            System.out.println(keyGen.getKey());
            decipher = new Decipher(reader.getText(),keyGen.getKey());
            Writer writer = new Writer(decipher.getText_decipher());
        }
        if (a=='C'){
            Cipher cipher = new Cipher(reader.getText());
            Writer writer = new Writer(cipher.getSb());
        }
    }

}
