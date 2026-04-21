package br.com.matheus.pereira.abstratctFactory;

public abstract class Car {
    private int horsepower;
    private String fuelSource;
    private String color;

    public Car(int horsepower, String fuelSource, String color) {
        this.horsepower = horsepower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void startEngine() {
        System.out.println(getClass().getSimpleName());
        System.out.println("The " + fuelSource + " engine has been started, and is ready to utilize " + horsepower);
    }

    public void clean() {
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines");
    }

    public void mechanicCheck() {
        System.out.println("Car has been checked by the mechanic. Everything looks good");
    }

    public void fuelCar() {
        System.out.println("Car is being filled with " + fuelSource.toLowerCase());
    }
}

