package br.com.mpereira.Generics;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // Garagem para todos os carros
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Honda("Civic"));
        listaCarros.add(new Toyota("Hilux"));
        listaCarros.add(new Honda("Fit"));
        listaCarros.add(new Toyota("Corola"));
        listaCarros.add(new Honda("City"));
        listaCarros.add(new Toyota("Etios"));

        System.out.println("---- Garagem Carros -----");
        for(Carro carro: listaCarros){
            System.out.println(carro);
        }
    }
}
