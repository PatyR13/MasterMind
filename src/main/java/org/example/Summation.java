package org.example;

public class Summation {
    public static int summation(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int fac = summation(15);
        System.out.println(fac);
    }
}
