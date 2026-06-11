package br.com.mpereira.teste;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TesteDemoTest {

    @Test
    public void testListaMulheres(){
        List<Pessoa> lista = new Pessoa("","").listarPessoas();
        List<Pessoa> listaApenasMulheres = lista.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Mulher"))
                .collect(Collectors.toList());

        for(Pessoa mulher : listaApenasMulheres){
            Assert.assertEquals("Mulher", mulher.getSexo());
        }
    }

}
