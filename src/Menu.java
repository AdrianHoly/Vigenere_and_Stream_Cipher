import Stream.StreamCipher;
import Vigenere.Vigenere;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public Menu() throws IOException {
        cipherSelector();
    }

    public void cipherSelector() throws IOException {
        while(true){
            System.out.println("Which decipher method do you want to use?");
            System.out.println("Type 'V' for Vigenere cipher");
            System.out.println("Type 'S' for Stream cipher");
            while(true){
                char type = scanner.next().charAt(0);
                if (type == 'V'){
                    actionSelector(type);
                } else if(type == 'S'){
                    actionSelector(type);
                } else {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    public void actionSelector(char t) throws IOException {
        if (t == 'V'){
            System.out.println("What Action do you want?");
            System.out.println("Decipher");
            System.out.println("Cipher");
            char action = scanner.next().charAt(0);
            while(true){
                if (action == 'D'){
                    fileSelector(t,action);
                } else if(action == 'C'){
                    fileSelector(t,action);
                } else {
                    System.out.println("Wrong input");
                }
            }
        } else if(t=='S'){
            fileSelector();
        }
    }

    public void fileSelector(){
        System.out.println("Please type a name of file you want to use!");
        try {
            while(true){
                String file = scanner.next();
                starter(file);
            }
        } catch (IOException e){
            System.out.println("Wrong FileName!");
        } finally {
            fileSelector();
        }
    }

    public void fileSelector(char t,char a ) throws IOException {
        System.out.println("Please type a name of file you want to use!");
        try {
            while(true){
                String file = scanner.next();
                starter(a,file);
            }
        } catch (FileNotFoundException e){
            System.out.println("Wrong FileName!");
        } finally {
            fileSelector(t,a);
        }
    }

    public void starter(String input) throws IOException {
        StreamCipher stream = new StreamCipher(input);
        startAgain();
    }

    public void starter(char a, String input) throws IOException {
        Vigenere vigenere = new Vigenere(input,a);
        startAgain();
    }

    public Boolean startAgain() throws IOException {
        System.out.println("Do you want to start again?");
        System.out.println("Type 'Y' for Yes, 'N' for No");
        while(true){
            char again = scanner.next().charAt(0);
            if (again == 'Y'){
                cipherSelector();
            } else if( again == 'N'){
                System.exit(0);
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
