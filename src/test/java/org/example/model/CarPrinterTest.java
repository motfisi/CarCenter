package test.java.org.example.model;
import main.java.org.example.model.CarPrinter;
import main.java.org.example.model.ConsoleCarPrinter;
import main.java.org.example.model.FileCarPrinter;
import main.java.org.example.model.Car;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class CarPrinterTest {

    @Test
    public void testConsoleCarPrinter() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Car car = new Car("Corolla", "Toyota", 2020, 25000);

        CarPrinter consolePrinter = new ConsoleCarPrinter();
        consolePrinter.printCar(car);

        System.out.flush();
        String printedCarInfo = outputStream.toString();

        assertTrue(printedCarInfo.contains("Car Information:"));
        assertTrue(printedCarInfo.contains("Brand: Toyota"));
        assertTrue(printedCarInfo.contains("Model: Corolla"));
        assertTrue(printedCarInfo.contains("Year: 2020"));
        assertTrue(printedCarInfo.contains("Price: $25000"));

        System.setOut(System.out);
    }


    @Test
    public void testFileCarPrinter() {
        String fileName = "test_cars.txt";

        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            try {
                Files.delete(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Car car = new Car("Mustang", "Ford", 2022, 45000);

        CarPrinter filePrinter = new FileCarPrinter(fileName);
        filePrinter.printCar(car);

        assertTrue(Files.exists(filePath));

        try {
            String fileContent = Files.readString(filePath);
            assertTrue(fileContent.contains("Car Information:"));
            assertTrue(fileContent.contains("Brand: Ford"));
            assertTrue(fileContent.contains("Model: Mustang"));
            assertTrue(fileContent.contains("Year: 2022"));
            assertTrue(fileContent.contains("Price: $45000"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

