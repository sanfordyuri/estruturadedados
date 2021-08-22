package br.com.yuri.Recursividade;

import java.util.ArrayList;
import java.util.Scanner;

public class URI1030 {

    private static int pulo;

    public static ArrayList<Integer> ordenar(ArrayList<Integer> arrayRecebidoAntesDeRemover, int ultimoRemovido, int k) {
        ArrayList<Integer> arrayOrdenado_pos_ultimoremovido = new ArrayList<>();
        ArrayList<Integer> arrayOrdenado_pre_ultimoremovido = new ArrayList<>();

        boolean podeIniciar = false;
        for(int n : arrayRecebidoAntesDeRemover) {
            if (n == ultimoRemovido) {
                podeIniciar = true;
            } else if (podeIniciar) {
                arrayOrdenado_pos_ultimoremovido.add(n);
            } else {
                arrayOrdenado_pre_ultimoremovido.add(n);
            }
        }

        ArrayList<Integer> arrayOrdenado = new ArrayList<>(arrayOrdenado_pos_ultimoremovido);
        arrayOrdenado.addAll(arrayOrdenado_pre_ultimoremovido);
        if(arrayOrdenado.size() == 2) {
            if(k%3 == 0) {
                ArrayList<Integer> arrayOrdenadoInverso = new ArrayList<>();
                arrayOrdenadoInverso.add(arrayOrdenado.get(1));
                arrayOrdenadoInverso.add(arrayOrdenado.get(0));
                return arrayOrdenadoInverso;
            }
            return arrayOrdenado;
        } else {
            return arrayOrdenado;
        }
    }

    public static ArrayList<Integer> lendaRecursiva(ArrayList<Integer> pessoas, int k) {
        if(pessoas.size() <= 2) {
            System.out.println("Chegou");
            return pessoas;
        } else {
            pulo = k - 1;
            int pessoaRemovida = pessoas.get(pulo);
            ArrayList<Integer> pessoas_ordenadas = ordenar( pessoas, pessoaRemovida, (pulo +1 ) );
            pessoas = pessoas_ordenadas;
            return lendaRecursiva(pessoas, (pulo +1 ));
        }
    }


    public static void lendaDeFlaviusJosephus(int n, int k) {
        ArrayList<Integer> numeroDePessoas = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            numeroDePessoas.add(i);
        }

        final int pulo = k-1;

        int pessoaRemovida = numeroDePessoas.get(pulo);
        ArrayList<Integer> arrayOrdenado = ordenar(numeroDePessoas, pessoaRemovida, k);
        System.out.println(arrayOrdenado);

        pessoaRemovida = arrayOrdenado.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente = ordenar(arrayOrdenado, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente);

        pessoaRemovida = arrayOrdenado_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente = ordenar(arrayOrdenado_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente);

        pessoaRemovida = arrayOrdenado_novamente_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente_novamente = ordenar(arrayOrdenado_novamente_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente_novamente);

        pessoaRemovida = arrayOrdenado_novamente_novamente_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente_novamente_novamente = ordenar(arrayOrdenado_novamente_novamente_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente_novamente_novamente);

        pessoaRemovida = arrayOrdenado_novamente_novamente_novamente_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente_novamente_novamente_novamente = ordenar(arrayOrdenado_novamente_novamente_novamente_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente_novamente_novamente_novamente);

        pessoaRemovida = arrayOrdenado_novamente_novamente_novamente_novamente_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente = ordenar(arrayOrdenado_novamente_novamente_novamente_novamente_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente);

        pessoaRemovida = arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente.get(pulo);
        ArrayList<Integer> arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente_novamente = ordenar(arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente, pessoaRemovida, k);
        System.out.println(arrayOrdenado_novamente_novamente_novamente_novamente_novamente_novamente_novamente);

    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nc = s.nextInt();

        for (int i = 0; i < nc; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            ArrayList<Integer> pessoas = new ArrayList<>();
            for (int j=1; j<=n; j++) {
                pessoas.add(j);
            }

            ArrayList<Integer> pessoaSobrevivente = lendaRecursiva(pessoas, k);
            System.out.println(pessoaSobrevivente);
        }
    }

}
