package menu;

import Stream.StreamCipher;
import Vigenere.Vigenere;

import java.io.IOException;

public class Start_of_ciphers extends File_selector {

    public void starter(String input,char t,char a) throws IOException {
        if (t==getVtype()){
            Vigenere vigenere = new Vigenere(input,a);
            startAgain();
        } else if(t==getStype()){
            StreamCipher stream = new StreamCipher(input);
            startAgain();
        }
    }


    public Boolean startAgain() throws IOException {
        System.out.println("Do you want to start again?");
        System.out.println("Type 'Y' for Yes, 'N' for No");
        while(true){
            char again = scanner.next().charAt(0);
            if (again == 'Y'){
                Start_menu sm = new Start_menu();
                sm.start_cycle();
            } else if( again == 'N'){
                System.exit(0);
            } else {
                System.out.println("Wrong input");
            }
        }
    }

}
