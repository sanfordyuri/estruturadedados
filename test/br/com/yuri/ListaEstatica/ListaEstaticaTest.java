package br.com.yuri.ListaEstatica;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaEstaticaTest {

    @Test
    void deveRetornarIndexDoisQuandoValorForYuri() {
        ListaEstatica lista = new ListaEstatica(3);
        lista.add("jose");
        lista.add("carlos");
        lista.add("Yuri");
        assertEquals(2, lista.retornarIndex("Yuri"));
    }

}