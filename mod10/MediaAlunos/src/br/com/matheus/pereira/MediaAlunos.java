package br.com.matheus.pereira;

import java.util.Scanner;

public class MediaAlunos {

    public static void main (String [] args){

        Scanner nome = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String aluno = nome.nextLine();
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a nota da P1: ");
        double nota1 = s.nextDouble();
        System.out.println("Digite a nota da P2: ");
        double nota2 = s.nextDouble();
        System.out.println("Digite a nota da P3: ");
        double nota3 = s.nextDouble();
        System.out.println("Digite a nota da P4: ");
        double nota4 = s.nextDouble();

        double media = (nota1 + nota2 + nota3 + nota4)/4;
        String status = "xxx";

        if (media > 7){
            status = "APROVADO!";
        }else if (media >= 5) {
            status = "RECUPERAÇÃO";
        } else {
            status = "REPROVADO";

        }
        System.out.println("***** Média Escola de Talentos *****");
        System.out.println("Aluno: " + aluno);
        System.out.println("Média " + media);
        System.out.println("Status: " + status);
        System.out.println("************************************");
    }
}
