package br.com.yuri.Recursividade;

import java.util.ArrayList;
import java.util.Scanner;

public class URI1030 {

    public static int[] ordenar(int[] arrayRecebidoAntesDeRemover, int ultimoRemovido) {

        ArrayList<Integer> arrayOrdenado_pos_ultimoremovido = new ArrayList<>();
        ArrayList<Integer> arrayOrdenado_pre_ultimoremovido = new ArrayList<>();

        boolean podeIniciar = false;

        for(int i=0; i < arrayRecebidoAntesDeRemover.length; i++) {
            int n = arrayRecebidoAntesDeRemover[i];
            if (n == ultimoRemovido) {
                podeIniciar = true;
            } else if (podeIniciar) {
                arrayOrdenado_pos_ultimoremovido.add(n);
            } else {
                arrayOrdenado_pre_ultimoremovido.add(n);
            }
        }


        int[] arrayOrdenado = new int[(arrayRecebidoAntesDeRemover.length - 1)];
        int contador = 0;
        for (int n : arrayOrdenado_pos_ultimoremovido) {
            arrayOrdenado[contador] = n;
            contador++;
        }
        for (int n : arrayOrdenado_pre_ultimoremovido) {
            arrayOrdenado[contador] = n;
            contador++;
        }
        return arrayOrdenado;
    }

    public static int[] lendaRecursiva(int[] pessoas, int k) {

        if (pessoas.length == 1) {
            return pessoas;
        } else {
            int pessoaRemovida;
            if (k >= pessoas.length) {
                pessoaRemovida = pessoas[(k % pessoas.length)];
            } else {
                pessoaRemovida = pessoas[(k)];
            }
            pessoas = ordenar(pessoas, pessoaRemovida);
            return lendaRecursiva(pessoas, k);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nc = s.nextInt();

        for (int i = 0; i < nc; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] pessoas = new int[n];
            for (int j = 1; j <= n; j++) {
                pessoas[j-1] = j;
            }

            int[] pessoaSobrevivente = lendaRecursiva(pessoas, k - 1);
            System.out.println("Case " + (i + 1) + ": " + pessoaSobrevivente[0]);
        }
    }

}
