package main.java.org.example.model;

public class HardcodedCarBuilder implements CarBuilder {
    @Override
    public Car buildCar() {
        // Создание объекта Car "жёстко" заданным образом
        return new Car("Model", "Brand", 2022, 50000);
    }
}