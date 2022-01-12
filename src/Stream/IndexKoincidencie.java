package Stream;

public class IndexKoincidencie {

    public static double ik(String text) {
        int abcd_sum = 26;
        int[] pocet_jednotlivych_znakov = new int[abcd_sum];
        int pocet_znakov_all = 0;
        char znak;
        int getIndex;
        for (int i = 0; i < text.length(); i++) {
            znak = text.charAt(i);
            if (znak >= 'A' && znak <= 'Z') {
                getIndex = znak - 'A';
                pocet_jednotlivych_znakov[getIndex]++;
                pocet_znakov_all++;
            }
        }
        double koincidencia = 0;
        for (int j = 0; j < abcd_sum; j++) {
            koincidencia += Math.pow((double) pocet_jednotlivych_znakov[j] / (double) pocet_znakov_all, 2);

        }
        return koincidencia;
    }
}
