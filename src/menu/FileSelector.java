package menu;

import java.io.IOException;
import java.util.Scanner;

public class FileSelector extends Action_selector {

    public void fileSelector(char t, char a) {
        Scanner scanner = new Scanner(System.in);
        String file;
        System.out.println("Please type a name of file you want to use!");
        if (t == Start_menu.V_TYPE || t == Start_menu.S_TYPE) {
            try {
                Start_of_ciphers soc;
                while (true) {
                    file = scanner.next();
                    soc = new Start_of_ciphers();
                    soc.starter(file, t, a);
                }
            } catch (IOException e) {
                System.out.println("Wrong FileName!");
            } finally {
                fileSelector(t, a);
            }
        }
    }
}
