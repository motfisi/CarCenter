package main.java.org.example.model;


public class ConsoleCarPrinter implements CarPrinter {
    @Override
    public void printCar(Car car) {
        // Вывод информации о машине в консоль
        System.out.println("Car Information:");
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: $" + car.getPrice());
    }
}


