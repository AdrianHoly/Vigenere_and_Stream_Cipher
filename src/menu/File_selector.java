package menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class File_selector extends Action_selector{
    public String file="";

    public void fileSelector(char t,char a){
        System.out.println("Please type a name of file you want to use!");
        if(t==getVtype()){
            try {
                while(true){
                    file = scanner.next();
                    Start_of_ciphers soc = new Start_of_ciphers();
                    soc.starter(file,t,a);
                }
            } catch (IOException e){
                System.out.println("Wrong FileName!");
            } finally {
                fileSelector(t,a);
            }
        } else if (t==getStype()) {
            try {
                while(true){
                    file = scanner.next();
                    Start_of_ciphers soc = new Start_of_ciphers();
                    soc.starter(file,t,a);
                }
            } catch (IOException e){
                System.out.println("Wrong FileName!");
            } finally {
                fileSelector(t,a);
            }
        }
    }
}
