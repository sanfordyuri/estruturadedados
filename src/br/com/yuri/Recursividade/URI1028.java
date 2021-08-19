package br.com.yuri.Recursividade;

import java.util.Scanner;

public class URI1028 {

    public static int mdcRecursivo(int f1, int f2) {

        if(f2 == 0) {
            return f1;
        } else {
            int resto = f1 % f2;
            f1 = f2;
            f2 = resto;
            return mdcRecursivo(f1,f2);
        }

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i=0; i< n; i++) {
            int f1 = s.nextInt();
            int f2 = s.nextInt();
            int mdc = mdcRecursivo(f1, f2);
            System.out.println(mdc);
        }

    }

}
