package org.example;

public class DnaToRna {

    public static String dnaToRna(String dna) {
        char[] rnaArray = new char[dna.length()];
        for (int i = 0; i < dna.length(); i++) {
            char c = dna.charAt(i);
            if((c == 'G') || (c == 'C') || (c == 'A')){
                rnaArray[i] = c;
            } else if (c == 'T'){
                rnaArray[i] = 'U';
            } else {
                break;
            }
        }
        return new String(rnaArray);
    }

    public static void main(String[] args) {
        String rna = dnaToRna("TTTT");
        System.out.println(rna);
    }
}


