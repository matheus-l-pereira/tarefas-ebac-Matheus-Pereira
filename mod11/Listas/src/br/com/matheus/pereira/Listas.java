package br.com.matheus.pereira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Listas {

    public static void main(String[] args) {
        System.out.println("Digite os nomes separados por vírgula: ");
        System.out.println("Ex: João, Maria, Antônio, ...");

        // Lê a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        // Divide a string pelos caracteres de vírgula
        String[] nomesArray = entrada.split(",");

        // Converte o array para uma List
        List<String> listaNomes = new ArrayList<>();
        for (String nome : nomesArray) {
            // Remove espaços em branco extras
            listaNomes.add(nome.trim());
        }

        // Ordena a lista em ordem alfabética
        Collections.sort(listaNomes);

        // Imprime os nomes ordenados
        System.out.println("\nNomes em ordem alfabética:");
        for (String nome : listaNomes) {
            System.out.println(nome);

        }

        scanner.close();

    }
}
