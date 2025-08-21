package br.com.matheus.pereira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Parte2 {

    public static void main(String[] args) {
            System.out.println("Digite os nomes e gêneros no formato: ");
            System.out.println("Ex: Maria-F, João-M, Carla-F, Alberto-M");

           Scanner scanner = new Scanner(System.in);
           String entrada = scanner.nextLine();

            // Listas separadas para cada gênero
            List<String> masculino = new ArrayList<>();
            List<String> feminino = new ArrayList<>();

            // Divide a string pelas vírgulas
            String[] pessoas = entrada.split(",");

            for (String pessoa : pessoas) {
                // Remove espaços em branco e divide pelo hífen
                String[] dados = pessoa.trim().split("-");

                if (dados.length == 2) {
                    String nome = dados[0].trim();
                    String genero = dados[1].trim().toUpperCase();

                    if (genero.equals("M")) {
                        masculino.add(nome);
                    } else if (genero.equals("F")) {
                        feminino.add(nome);
                    }
                }
            }

            // Ordena as listas
            Collections.sort(masculino);
            Collections.sort(feminino);

            // Imprime os resultados
             System.out.println("\n**** Grupo Masculino ****");
             for (String nome: masculino){
                 System.out.println(nome);
             }

             System.out.println("\n**** Grupo Feminino ****");
             for (String nome: feminino){
                 System.out.println(nome);
             }


            }
        }

