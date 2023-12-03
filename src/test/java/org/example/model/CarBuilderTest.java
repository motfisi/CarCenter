package test.java.org.example.model;
import org.junit.jupiter.api.Test;
import main.java.org.example.model.Car;
import main.java.org.example.model.CarBuilder;
import main.java.org.example.model.RandomCarBuilder;
import main.java.org.example.model.HardcodedCarBuilder;
import static org.junit.jupiter.api.Assertions.*;

public class CarBuilderTest {

    @Test
    public void testRandomCarBuilder() {
        CarBuilder randomCarBuilder = new RandomCarBuilder();
        Car randomCar = randomCarBuilder.buildCar();

        assertNotNull(randomCar); // Убедимся, что объект создан
        assertNotNull(randomCar.getBrand()); // Убедимся, что у машины есть марка
        assertNotNull(randomCar.getModel()); // Убедимся, что у машины есть модель
        assertTrue(randomCar.getYear() >= 2000 && randomCar.getYear() <= 2022); // Проверим, что год в разумных пределах
        assertTrue(randomCar.getPrice() >= 20000 && randomCar.getPrice() <= 100000); // Проверим, что цена в разумных пределах
    }

    @Test
    public void testHardcodedCarBuilder() {
        CarBuilder hardcodedCarBuilder = new HardcodedCarBuilder();
        Car hardcodedCar = hardcodedCarBuilder.buildCar();

        assertNotNull(hardcodedCar); // Убедимся, что объект создан
        assertEquals("Brand", hardcodedCar.getBrand()); // Убедимся, что у машины заданная марка
        assertEquals("Model", hardcodedCar.getModel()); // Убедимся, что у машины заданная модель
        assertEquals(2022, hardcodedCar.getYear()); // Убедимся, что у машины заданный год
        assertEquals(50000, hardcodedCar.getPrice()); // Убедимся, что у машины заданная цена
    }
}
