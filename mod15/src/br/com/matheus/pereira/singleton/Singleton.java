package br.com.matheus.pereira.singleton;

public class Singleton {
    //1 - única instância da classe
    private static Singleton singleton;

    //2 - Construtor privado: este impede o uso do "new"
    private Singleton() {

    }
    //3 - metodo para fornecer a instancia
    public static Singleton getInstance() {
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

}
/*Singleton é usado quando queremos instanciar a classe apenas uma vez.

 */