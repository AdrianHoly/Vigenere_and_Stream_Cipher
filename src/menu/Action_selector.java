package menu;

import java.io.IOException;

public class Action_selector extends Start_menu{
    public char action;
    private char D_action='D';
    private char C_action='C';

    public void actionSelector(char ch) throws IOException {
        if (ch == getVtype()){
            System.out.println("What Action do you want?");
            System.out.println("Decipher");
            System.out.println("Cipher");
            action = scanner.next().charAt(0);
            while(true){
                if (action == D_action){
                    File_selector fs = new File_selector();
                    fs.fileSelector(getVtype(),getD_action());
                } else if(action == C_action){
                    File_selector fs = new File_selector();
                    fs.fileSelector(getVtype(),getC_action());
                } else {
                    System.out.println("Wrong input");
                }
            }
        } else if(ch == getStype()){
            File_selector fs = new File_selector();
            fs.fileSelector(getStype(),getC_action());
        }
    }

    public char getD_action() {
        return D_action;
    }

    public char getC_action() {
        return C_action;
    }


}
