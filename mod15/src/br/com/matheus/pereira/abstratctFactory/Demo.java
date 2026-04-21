package br.com.matheus.pereira.abstratctFactory;

public class Demo {

    public static void main(String[] args) {
        Customer cliente = new Customer("A", false);
        Factory factory = getFactory(cliente);
        factory.create(cliente.getGradeRequest());
        Car car = factory.create(cliente.getGradeRequest());
        car.startEngine();
    }

    private static Factory getFactory(Customer cliente){
        if(cliente.hasCompanyContract()){
            return new ContratosFactory();
        } else {
            return new SemContratosFactory();
        }
    }
}
