package Vigenere;

public class FrequencyAnalysis {
    double[] freq_analysis_res = new double[26];
    public FrequencyAnalysis(String input) {
        freq_analysis_res=freq_analysis(input);

    }

    public double[] freq_analysis(String input){
        int[] chars_counter = new int[26];
        double[] freq_analysis_column = new double[26];
        int chars_all=0;
        char ch;
        int getIndex;
        for(int i=0;i<input.length();i++){
            ch=input.charAt(i);
            getIndex = ch-'A';
            chars_counter[getIndex]++;
            chars_all++;
        }
        for (int i=0;i<26;i++){
            freq_analysis_column[i] = (double)chars_counter[i]/(double)chars_all;
        }
        return freq_analysis_column;
    }

    public double[] getFreq_analysis_res() {
        return freq_analysis_res;
    }
}
