package br.com.yuri.Recursividade;

import java.util.Scanner;

public class URI1029 {

    static int calls = 0;
    public static int fib(int x) {
        calls += 1;
        if(x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fib(x-1) + fib(x-2);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i=0; i<n; i++) {
            int x = s.nextInt();
            int fib = fib(x);
            System.out.println("fib("+x+") = " + (calls - 1) + " calls = " + fib);
            calls = 0;
        }
    }

}
