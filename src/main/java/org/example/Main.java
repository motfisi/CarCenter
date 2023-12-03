//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package main.java.org.example;

import java.util.Scanner;
import main.java.org.example.model.Car;
import main.java.org.example.model.CarCenter;
import main.java.org.example.model.Customer;
import main.java.org.example.model.NewCar;
import main.java.org.example.model.UsedCar;
import java.util.Scanner;
import main.java.org.example.model.*;

public class Main {
    public static void main(String[] args) {
        CarCenter dealer = new CarCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в Автосалон!");

        CarPrinter consolePrinter = new ConsoleCarPrinter(); // Создание консольного принтера
        CarPrinter filePrinter = new FileCarPrinter("car_info.txt"); // Создание принтера для файла

        int choice;
        do {
            System.out.println("\nВыберите действие:\n1) Добавить автомобиль в Автосалон\n2) Вывести все автомобили, имеющиеся в салоне\n3) Вывести самый дорогой автомобиль\n4) Вывести самый дешевый автомобиль\n5) Добавить клиента\n6) Вывести всех клиентов Автосалона\n7) Выйти");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите название автомобиля: ");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    System.out.println("Введите модель автомобиля: ");
                    String model = scanner.nextLine();
                    System.out.println("Введите год выпуска автомобиля: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите стоимость автомобиля: ");
                    int price = scanner.nextInt();
                    System.out.println("Введите тип машины, которую хотите добавить:\n1) Добавить новый автомобиль\n2) Добавить подержанный автомобиль\n");
                    int typeChoice = scanner.nextInt();
                    int mileage;
                    switch (typeChoice) {
                        case 1:
                            System.out.println("Введите гарантийный срок на автомобиль: ");
                            mileage = scanner.nextInt();
                            dealer.addCar(new NewCar(brand, model, year, price, mileage));
                            System.out.println("Автомобиль добавлен!");
                            break;
                        case 2:
                            System.out.println("Введите пробег автомобиля: ");
                            mileage = scanner.nextInt();
                            dealer.addCar(new UsedCar(brand, model, year, price, mileage));
                            System.out.println("Автомобиль добавлен!");
                            break;
                        default:
                            System.out.println("Неверный выбор типа автомобиля");
                    }
                    break;
                case 2:
                    System.out.println("Информация об автомобилях в консоль:");
                    dealer.printAllCars();
                    System.out.println("Информация об автомобилях записана в файл.");
                    for (Car car : dealer.getCars()) {
                        filePrinter.printCar(car);
                    }
                    System.out.println("Общая стоимость автосалона: $" + dealer.getTotalValue());
                    break;
                case 3:
                    Car mostExpensive = dealer.getMostExpensiveCar();
                    if (mostExpensive != null) {
                        System.out.println("Самый дорогой автомобиль:");
                        consolePrinter.printCar(mostExpensive);
                        filePrinter.printCar(mostExpensive);
                    }
                    break;
                case 4:
                    Car cheapest = dealer.getCheapestCar();
                    if (cheapest != null) {
                        System.out.println("Самый дешевый автомобиль:");
                        consolePrinter.printCar(cheapest);
                        filePrinter.printCar(cheapest);
                    }
                    break;
                case 5:
                    System.out.println("Введите Имя и Фамилию клиента: ");
                    scanner.nextLine();
                    String customerName = scanner.nextLine();
                    System.out.println("Введите адрес электронной почты клиента: ");
                    String customerEmail = scanner.nextLine();
                    System.out.println("Введите номер телефона клиента: ");
                    String customerPhone = scanner.nextLine();
                    dealer.addCustomer(new Customer(customerName, customerEmail, customerPhone));
                    break;
                case 6:
                    dealer.printCustomers();
                    break;
                default:
                    if (choice > 7 || choice < 0) {
                        System.out.println("Неверные данные");
                    }
            }
        } while (choice != 7);
    }
}
