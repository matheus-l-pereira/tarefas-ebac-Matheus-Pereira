package br.com.mpereira.stream;

import java.util.List;

public class Pessoa {

    private String nome;

    private String sexo;

    public Pessoa(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Pessoa> listarPessoas(){
        Pessoa pessoa1 = new Pessoa("Antonio Alves", "Homem");
        Pessoa pessoa2 = new Pessoa("Carlos Shinui", "Homem");
        Pessoa pessoa3 = new Pessoa("Olívia Silva", "Mulher");
        Pessoa pessoa4 = new Pessoa("Jhoni Gonçalves", "Homem");
        Pessoa pessoa5 = new Pessoa("Bruna Heinz", "Mulher");
        return List.of(pessoa1,pessoa2,pessoa3,pessoa4,pessoa5);
    }

}
