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

        pulo = k - 1;

        if(pulo == pessoas.size()) {
            int novo_pulo = (pessoas.size()%pulo);
            return lendaRecursiva(pessoas, novo_pulo + 1);
        } else if(pessoas.size() <= 2) {
            System.out.println("Chegou");
            return pessoas;
        } else {
            int pessoaRemovida = pessoas.get(pulo);
            ArrayList<Integer> pessoas_ordenadas = ordenar( pessoas, pessoaRemovida, (pulo +1 ) );
            pessoas = pessoas_ordenadas;
            return lendaRecursiva(pessoas, (pulo +1 ));
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

            ArrayList<Integer> pessoaSobrevivente = lendaRecursiva(pessoas, k);
            System.out.println(pessoaSobrevivente);
        }
    }

}
