package br.com.mpereira.stream;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<Pessoa> lista = new Pessoa("", "").listarPessoas();

        lista.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Mulher"))
                .forEach(pessoa -> System.out.println(pessoa.getNome()));
    }
}
