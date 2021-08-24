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
                System.out.println("Olha: " + n);
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

        if(pessoas.size() == 3) {
            System.out.println("Chegou");
            return pessoas;
        } else if(k >= pessoas.size()) {
            int novo_pulo = (k % pessoas.size());
            return lendaRecursiva(pessoas, novo_pulo);
        } else {
            int pessoaRemovida = pessoas.get(k);
            ArrayList<Integer> pessoas_ordenadas = ordenar( pessoas, pessoaRemovida, k );
            pessoas = pessoas_ordenadas;
            return lendaRecursiva(pessoas, k);
        }

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

            ArrayList<Integer> pessoaSobrevivente = lendaRecursiva(pessoas, k-1);
            System.out.println(pessoaSobrevivente);
        }
    }

}
