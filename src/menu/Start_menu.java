package menu;

import java.util.Scanner;

public class Start_menu {
    public static final char V_TYPE ='V';
    public static final char S_TYPE ='S';

    public static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        FileSelector fs;
        while(true){
            System.out.println("Which decipher method do you want to use?");
            System.out.println("Type 'V' for Vigenere cipher");
            System.out.println("Type 'S' for Stream cipher");
            char type = scanner.next().charAt(0);
            switch (type) {
                case V_TYPE:
                case S_TYPE:
                    Action_selector.actionSelector(type);
                    break;
                default:
                    System.out.println("Wrong input. Try again.");
            }
        }
    }
}
