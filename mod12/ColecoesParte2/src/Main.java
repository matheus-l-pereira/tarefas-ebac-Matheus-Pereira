import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite e nome e o sexo no seguinte formato: Nome-S ");
        System.out.println("Exemplo: Jorge-M, Maria-F, Linda-F, Ronaldo-M ");
        String entrada = scanner.nextLine();

        Map<String, List<String>> grupos = new HashMap<>();

        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        String[] pessoas = entrada.split(",");

        for (String pessoa : pessoas){
            String[] dados = pessoa.trim().split("-");

            if(dados.length == 2){
                String nome = dados[0].trim();
                String genero = dados[1].trim().toUpperCase();

                if (grupos.containsKey(genero)) {
                    grupos.get(genero).add(nome);
                }
            }
        }

        for (List<String> lista : grupos.values()) {
            Collections.sort(lista);
        }

        System.out.println("\n **** Grupo Masculino - M ****");
            for (String nome : grupos.get("M") ){
                System.out.println(nome);
            }
        System.out.println("\n **** Grupo Feminino - F ****");
            for (String nome : grupos.get("F")){
                System.out.println(nome);
            }
    }

}


