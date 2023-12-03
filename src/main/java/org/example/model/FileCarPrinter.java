package main.java.org.example.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCarPrinter implements CarPrinter {
    private String fileName;

    public FileCarPrinter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void printCar(Car car) {
        // Вывод информации о машине в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Car Information:\n");
            writer.write("Brand: " + car.getBrand() + "\n");
            writer.write("Model: " + car.getModel() + "\n");
            writer.write("Year: " + car.getYear() + "\n");
            writer.write("Price: $" + car.getPrice() + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}