package Vigenere;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    public Writer(StringBuilder sb) {
        fileSaver(sb);
    }
//SPRAVIT INTERFACE NA CHOOSE CI VYPISAT ALEBO ULOZIT
    public void fileSaver(StringBuilder input){
        while(true){
            System.out.println("Do you want to save this encrypted text?");
            System.out.println("'Y' for Yes, 'N' for No");
            Scanner scanner = new Scanner(System.in);
            char answer = scanner.next().charAt(0);
            if(answer == 'Y'){
                fileCreator(input);
            } else if(answer == 'N'){

            }
            break;
        }
    }

    public void fileCreator(StringBuilder input){
        String writing = input.toString();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type the name of file please");
            String fileName = scanner.next();
            String file = "C:/Users/Ado/IdeaProjects/Vigenere_&_Stream_Cipher/src/Vigenere/textfiles/"+fileName + ".txt";
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(writing);
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
            break;
        }
    }
}
