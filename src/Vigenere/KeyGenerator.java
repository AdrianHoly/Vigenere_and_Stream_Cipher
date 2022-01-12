package Vigenere;

import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {
    private int minKey = 20;
    private int maxKey = 29;
    private static double fa_sk[] = {0.1116, 0.0178, 0.0246, 0.0376, 0.0932, 0.0016, 0.0018, 0.0248, 0.0575, 0.0216, 0.0396, 0.0437, 0.0358, 0.0595, 0.0954, 0.0301, 0.0000, 0.0471, 0.0612, 0.0572, 0.0331, 0.0460, 0.0000, 0.0003, 0.0267, 0.0306};
    private static double fa_eng[] = {0.0856, 0.0139, 0.0279, 0.0378, 0.1304, 0.0289, 0.0199, 0.0526, 0.0627, 0.0019, 0.042, 0.0339, 0.0249, 0.0707, 0.0797, 0.0199, 0.0012, 0.0977, 0.0607, 0.1045, 0.0249, 0.0092, 0.0149, 0.0017, 0.0199, 0.0008};
    private String key="";
    private int dlzka_hesla;
    private List<String> columns = new ArrayList<>();

    public KeyGenerator(StringBuilder input) {
        dlzka_hesla=keyLength(input);
        keyGen(columnGen(input,dlzka_hesla));
    }

    public int keyLength(StringBuilder input){
        String znaky_add="";
        String text = input.toString();
        List<String> znaky = new ArrayList<>();
        List<Integer> znaky_dist = new ArrayList<>();
        for (int i=0; i<text.length()-3; i++){
            for (int j=i+1;j<text.length()-3;j++){
                if (text.charAt(i)==text.charAt(j) && text.charAt(i+1)==text.charAt(j+1) && text.charAt(i+2)==text.charAt(j+2)){
                    znaky_add = Character.toString(text.charAt(i)) + Character.toString(text.charAt(i+1)) + Character.toString(text.charAt(i+2));
                    znaky.add(znaky_add);
                    znaky_dist.add(j-i);
                }
            }
        }
        List<Integer> nasobky = new ArrayList<>();
        int pom=0;
        for (int i=minKey;i<maxKey+1;i++){
            for (int j=0;j<znaky_dist.size();j++){
                if (znaky_dist.get(j)%i==0){
                    pom++;
                }
            }
            nasobky.add(pom);
            pom=0;
        }
        for (int i=0;i<nasobky.size();i++){
            if (nasobky.get(i)>dlzka_hesla){
                dlzka_hesla = nasobky.get(i);
            }
        }
        dlzka_hesla = nasobky.indexOf(dlzka_hesla)+minKey;
        System.out.println("dlzka hesla: "+dlzka_hesla);
        return dlzka_hesla;
    }

    public List<String> columnGen(StringBuilder s, int key_length){
        String column="";
        String text_input = s.toString();
        for (int i=0;i<key_length;i++){
            for (int j=i;j<text_input.length();j=j+key_length){
                column +=text_input.charAt(j);
            }
            columns.add(column);
            column="";
        }

        return columns;
    }

    public void keyGen(List<String> al){

        int column_size=al.size();
        double[] column_after_fa = new double[column_size];
        char ch = 'A';
        int column_index;
        double maxValue;
        double endValue;
        for (int i=0;i<dlzka_hesla;i++){
            FrequencyAnalysis fa = new FrequencyAnalysis(columns.get(i));
            column_after_fa= fa.getFreq_analysis_res();
            maxValue=100.00;
            for (int j=0;j<26;j++){
                endValue=0;
                for (int k=0;k<26;k++){
                    column_index=(j+k)%26;
                    endValue += Math.abs(fa_sk[k]-column_after_fa[column_index]);
                }
                if (maxValue>endValue){
                    maxValue=endValue;
                    ch = (char)(j+'A');
                }
            }
            key += ch;
        }
    }

    public String getKey() {
        return key;
    }
}
