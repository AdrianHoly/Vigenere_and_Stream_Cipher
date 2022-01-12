package Vigenere;

public class Decipher {
    private StringBuilder text_decipher;
    public Decipher(StringBuilder input, String key) {
        decode(input,key);
        text_decipher = new StringBuilder();

    }

    public void decode(StringBuilder input, String key){
        char ch;
        for (int i=0,j=0;i<input.toString().length();i++){
            if (input.toString().charAt(i) >= 'A' && input.toString().charAt(i)<='Z'){
                ch=input.toString().charAt(i);
                text_decipher.append((char)((26+ch-key.charAt(j))%26+'A'));
                j++;
                j=j%key.length();
            } else {
                text_decipher.append(input.toString().charAt(i));
            }
        }
    }

    public StringBuilder getText_decipher() {
        return text_decipher;
    }
}
