package Stream;
import java.io.*;

public class StreamCipher {
    double my_ik;
    double ik_prob = 0.055;

    public StreamCipher(String input_text) throws IOException {
        String fileText = reader(input_text);
        seeder(fileText);
    }

    public String reader(String input) throws IOException {
        String line;
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Ado/IdeaProjects/Vigenere_&_Stream_Cipher/src/Stream/textfiles/" + input));
        while((line = br.readLine()) != null){
            text.append(line);
        }
        return text.toString().toUpperCase();
    }

    public void seeder(String fileText) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 217728; i++) {
            sb.setLength(0);
            Rand_generator gen = new Rand_generator(i);
//            System.out.println(i);
            for (int j = 0; j < fileText.length(); j++) {
                char ch = fileText.charAt(j);
                if (ch >= 'A' && ch <= 'Z') {
                    int znak_value = ch - 'A';
                    int rand = (int) (26 * gen.randomizer());
                    int calc = (znak_value + (26 - rand)) % 26;
                    sb.append((char) (calc + 'A'));
                } else {
                    sb.append(ch);
                }
            }

            String text_no_line;
            my_ik = IndexKoincidencie.ik(sb.toString());
            if (my_ik >= ik_prob) {
                text_no_line = sb.toString().replaceAll("[\t\n\r]+", " ");
                System.out.println("seed: " + i);
                System.out.println(text_no_line);
            }
        }
    }
}
