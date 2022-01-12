package Vigenere;

public class TextNoSpaces {
    private StringBuilder sb = new StringBuilder();

    public TextNoSpaces(StringBuilder input) {
        String text_input = input.toString();
        char ch;
        for (int i=0;i<text_input.length();i++){
            ch = text_input.charAt(i);
            if (ch >= 'A' && ch <= 'Z'){
                sb.append(ch);
            }
        }
    }

    public StringBuilder getSb() {
        return sb;
    }
}
