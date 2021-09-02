package br.com.yuri.ListaEstatica;
class ListaEstatica {

    int tamanho;
    String[] lista;

    public ListaEstatica(int tamanho) {
        lista = new String[tamanho];
        this.tamanho = 0;
    }

    public void add(String i) {
        lista[tamanho] = i;
        tamanho++;
    }

    public void removerPosicao(int index) {
        String[] nova_lista = new String[tamanho-1];
        String valor_removido = lista[index];
        for(int i = 0; i< tamanho; i++) {
            if(!valor_removido.equals(lista[i])) {
                nova_lista[i] = lista[i];
            }
        }
        lista = nova_lista;
        tamanho = tamanho-1;
    }

    public void addPosicao(int posicao, String valor) throws Exception {
        if(!(posicao > tamanho)) {
            lista[posicao] = valor;
        }  else {
            throw new Exception("Essa posicao nao existe na lista");
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void clear() {
        lista = new String[0];
        tamanho = 0;
    }

    public int retornarIndex(String valor) {
        int index = -1;

        for(int i = 0; i< tamanho; i++) {
            if(lista[i].equals(valor)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(lista[i] + " ");
        }
    }

}
