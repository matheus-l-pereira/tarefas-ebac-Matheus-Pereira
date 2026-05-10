package br.com.mpereira.Generics;

public class Demo {
    public static void main(String[] args) {
        // Garagem só para carros da marca Honda
        Garagem<Honda> garagemHonda = new Garagem<>();
        garagemHonda.adicionarCarro(new Honda("Civic"));
        garagemHonda.adicionarCarro(new Honda("Fit"));
        garagemHonda.adicionarCarro(new Honda("City"));

        // Garagem só para carros da marca Toyota
        Garagem<Toyota> garagemToyota = new Garagem<>();
        garagemToyota.adicionarCarro(new Toyota("Corola"));
        garagemToyota.adicionarCarro(new Toyota("Hilux"));
        garagemToyota.adicionarCarro(new Toyota("Etios"));

        System.out.println("---- Garagem Honda -----");
        garagemHonda.exibirCarros();

        System.out.println("---- Garagem Toyota -----");
        garagemToyota.exibirCarros();
    }
}
