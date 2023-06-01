package test.java.org.example.model;

import main.java.org.example.model.Car;
import main.java.org.example.model.CarCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarCenterTest {

    private CarCenter carCenter;

    @BeforeEach
    public void setUp() {
        carCenter = new CarCenter();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("5-series", "BMW", 2022, 30000);
        carCenter.addCar(car);

        List<Car> cars = carCenter.getCars();
        assertNotNull(cars);
        assertEquals(1, cars.size());
        assertEquals(car, cars.get(0));
    }

    @Test
    public void testGetMostExpensiveCar() {
        Car car1 = new Car("5-series", "BMW", 2022, 30000);
        Car car2 = new Car("CLS", "Mercedes-Benz", 2015, 35000);
        Car car3 = new Car("Octavia RS", "Skoda", 2018, 50000);

        carCenter.addCar(car1);
        carCenter.addCar(car2);
        carCenter.addCar(car3);

        Car mostExpensiveCar = carCenter.getMostExpensiveCar();
        assertNotNull(mostExpensiveCar);
        assertEquals(car3, mostExpensiveCar);
    }

    @Test
    public void testGetCheapestCar() {
        Car car1 = new Car("5-series", "BMW", 2022, 30000);
        Car car2 = new Car("CLS", "Mercedes-Benz", 2015, 35000);
        Car car3 = new Car("Octavia RS", "Skoda", 2018, 50000);

        carCenter.addCar(car1);
        carCenter.addCar(car2);
        carCenter.addCar(car3);

        Car cheapestCar = carCenter.getCheapestCar();
        assertNotNull(cheapestCar);
        assertEquals(car1, cheapestCar);
    }

    @Test
    public void testGetCarsWhenEmpty() {
        List<Car> cars = carCenter.getCars();
        assertNotNull(cars);
        assertEquals(0, cars.size());
    }

    @Test
    public void testGetMostExpensiveCarWhenEmpty() {
        Car mostExpensiveCar = carCenter.getMostExpensiveCar();
        assertNull(mostExpensiveCar);
    }

    @Test
    public void testGetCheapestCarWhenEmpty() {
        Car cheapestCar = carCenter.getCheapestCar();
        assertNull(cheapestCar);
    }
}