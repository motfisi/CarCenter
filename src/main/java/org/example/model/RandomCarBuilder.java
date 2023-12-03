package main.java.org.example.model;
import java.util.Random;

public class RandomCarBuilder implements CarBuilder {
    @Override
    public Car buildCar() {
        // Создание объекта Car случайным образом
        Random random = new Random();
        String[] brands = {"BMW", "Mercedes-Benz", "Audi"};
        String[] models = {"X5", "E-Class", "A4"};
        int randomBrandIndex = random.nextInt(brands.length);
        int randomModelIndex = random.nextInt(models.length);
        int randomYear = 2000 + random.nextInt(23); // Год от 2000 до 2022
        int randomPrice = 20000 + random.nextInt(80000); // Стоимость от 20000 до 100000

        return new Car(models[randomModelIndex], brands[randomBrandIndex], randomYear, randomPrice);
    }
}