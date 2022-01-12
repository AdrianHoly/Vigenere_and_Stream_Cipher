package menu;

import java.io.IOException;
import java.util.Scanner;

public class Start_menu {
    private char Vtype='V';
    private char Stype='S';
    private char type;
    Scanner scanner = new Scanner(System.in);

    public void start_cycle() throws IOException {
        while(true){
            System.out.println("Which decipher method do you want to use?");
            System.out.println("Type 'V' for Vigenere cipher");
            System.out.println("Type 'S' for Stream cipher");
            while(true){
                type = scanner.next().charAt(0);
                if (type == Vtype){
                    Action_selector as = new Action_selector();
                    as.actionSelector(type);
                } else if(type == Stype){
                    Action_selector as = new Action_selector();
                    as.actionSelector(type);
                } else {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    public char getVtype() {
        return Vtype;
    }

    public char getStype() {
        return Stype;
    }
}
