package Vigenere;

import java.util.Scanner;

public class Cipher {
    private String key="";
    private StringBuilder sb = new StringBuilder();
    public Cipher(StringBuilder input) {
        key = keyMaker();
        sb=coder(input,key);
    }



    public String keyMaker(){
        System.out.println("Please type your Key");
        System.out.println("Make sure it is in interval <20-29>");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.next();
        while (true){
            if(sc.length() >= 20 && sc.length() <= 29){
                return sc;
            } else {
                System.out.println("Wrong Key!");
            }
        }
    }

    public StringBuilder coder(StringBuilder input, String k){
        StringBuilder cipher_text = new StringBuilder();
        String text_previous = input.toString().toUpperCase();
        char ch;
        for (int i=0,j=0;i<text_previous.length();i++){
            if(text_previous.charAt(i) >= 'A' && text_previous.charAt(i)<='Z'){
                ch = text_previous.charAt(i);
                cipher_text.append((char)((ch+k.charAt(j)-2 * 'A') % 26+'A'));
                j++;
                j=j%k.length();
            } else {
                cipher_text.append(text_previous.charAt(i));
            }
        }
        return cipher_text;
    }

    public StringBuilder getSb() {
        return sb;
    }
}
