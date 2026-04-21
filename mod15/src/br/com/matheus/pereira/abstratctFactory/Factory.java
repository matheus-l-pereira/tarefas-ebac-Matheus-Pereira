package br.com.matheus.pereira.abstratctFactory;

public abstract class Factory {

    public Car create(String requestedGrade){
        Car car = retriveCar(requestedGrade);
        car = prepareCar(car);
        return car;
    }

    private Car prepareCar (Car car){
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
        return car;
    }
    abstract Car retriveCar(String requestedGrade);
}
