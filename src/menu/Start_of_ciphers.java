package menu;

import Stream.StreamCipher;
import Vigenere.Vigenere;

import java.io.IOException;
import java.util.Scanner;

public class Start_of_ciphers extends FileSelector {
    public static final char ACCEPT ='Y';
    public static final char DECLINE ='N';

    public void starter(String input, char t, char a) throws IOException {
        if (t == Start_menu.V_TYPE) {
            new Vigenere(input, a);
            startAgain();
        } else if (t == Start_menu.S_TYPE) {
            new StreamCipher(input);
            startAgain();
        }
    }


    public boolean startAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to start again?");
        System.out.println("Type 'Y' for Yes, 'N' for No");
        while (true) {
            char again = scanner.next().charAt(0);
            if (again == ACCEPT) {
                Start_menu.startProgram();
            } else if (again == DECLINE) {
                System.exit(0);
            } else {
                System.out.println("Wrong input");
            }
        }
    }

}
