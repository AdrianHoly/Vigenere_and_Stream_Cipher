package menu;

import java.util.Scanner;

public class Action_selector extends Start_menu{
    public static final char D_ACTION ='D';
    public static final char C_ACTION ='C';

    public static void actionSelector(char ch) {
        Scanner scanner = new Scanner(System.in);
        FileSelector fs = new FileSelector();
        char action;

        if (ch == Start_menu.V_TYPE){
            System.out.println("What Action do you want?");
            System.out.println("Decipher");
            System.out.println("Cipher");
            action = scanner.next().charAt(0);
            while(true){
                if (action == D_ACTION){
                    fs.fileSelector(Start_menu.V_TYPE, D_ACTION);
                } else if(action == C_ACTION){
                    fs.fileSelector(Start_menu.V_TYPE, Action_selector.C_ACTION);
                } else {
                    System.out.println("Wrong input");
                }
            }
        } else if(ch == Start_menu.S_TYPE){
            fs.fileSelector(Start_menu.S_TYPE,C_ACTION);
        }
    }
}
