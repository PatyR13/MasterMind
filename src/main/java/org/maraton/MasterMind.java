package org.maraton;

import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args) {
        Konsola konsola = new Konsola();

        konsola.przywitanieGraczaIZasady();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int codeLength = 4;
        int maxDigit = 6;
        int[] secretCode = new int[codeLength];
        int[] userCode = new int[codeLength];
        boolean guessed = false;



        for(int i = 0; i < codeLength; i++){
            secretCode[i] = random.nextInt(maxDigit) + 1;
        }

        while(guessed == false) {
            System.out.println("Wprowadź swoją próbę: ");
            String guess = scanner.nextLine();

            try {
                if (guess.length() != codeLength) {
                    throw new NumberFormatException();
                }
                for (int i = 0; i < codeLength; i++) {
                    userCode[i] = Character.getNumericValue(guess.charAt(i));
                    if (userCode[i] < 1 || userCode[i] > maxDigit) {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Wprowadzony kod jest nieprawidłowy. Wprowadź " + codeLength + " cyfrowy kod składający się z liczb od 1 do " + maxDigit + ".");
            }

            int identicalButNotInPlace = 0;
            int identicalAndInPlace = 0;
            boolean[] countedInUserCode = new boolean[codeLength];
            boolean[] countedInSecretCode = new boolean[codeLength];

            for (int i = 0; i < codeLength; i++){
                if (userCode[i] == secretCode[i]){
                    identicalAndInPlace++;
                    countedInUserCode[i] = true;
                    countedInSecretCode[i] = true;
                }
            }

            for (int i = 0; i < codeLength; i++){
                if (countedInUserCode[i] == false){
                    for (int j = 0; j < codeLength; j++){
                        if (countedInSecretCode[j] == false && userCode[i] == secretCode[j]){
                            identicalButNotInPlace++;
                            countedInUserCode[i] = true;
                            countedInSecretCode[i] = true;
                        }
                    }
                }
            }
            if (identicalAndInPlace == codeLength){
                System.out.println("Gratulacje! Odgadłeś kod!");
                guessed = true;
            } else {
                System.out.println("Ilość poprawnych cyfr na poprawnej pozycji: " + identicalAndInPlace);
                System.out.println("Ilość poprawnych cyfr na niepoprawnej pozycji: " + identicalButNotInPlace);
            }
        }


        scanner.close();
    }
}
