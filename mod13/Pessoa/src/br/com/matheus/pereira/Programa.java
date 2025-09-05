package br.com.matheus.pereira;

public class Programa {

    public static void main (String[] args){
        PessoaFisica pessoa = new PessoaFisica();

        pessoa.setNome("Matheus");
        pessoa.setSobrenome("Pereira");
        pessoa.setCpf(84682685L);


        System.out.println("**** Dados da Pessoa Física ****");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Sobrenome: " + pessoa.getSobrenome());
        System.out.println("CPF: " + pessoa.getCpf());

        PessoaJuridica empresa = new PessoaJuridica();
        
        empresa.setNome("Goiabinhas Enterprise");
        empresa.setCnpj(446485L);

        System.out.println("**** Dados da Pessoa Jurídica ****");
        System.out.println("Nome: " + empresa.getNome());
        System.out.println("CNPJ: " + empresa.getCnpj());


    }
}

