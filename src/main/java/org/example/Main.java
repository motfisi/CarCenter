//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//dsaasdasd
package main.java.org.example;

import java.util.Scanner;
import main.java.org.example.model.Car;
import main.java.org.example.model.CarCenter;
import main.java.org.example.model.Customer;
import main.java.org.example.model.NewCar;
import main.java.org.example.model.UsedCar;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        CarCenter dealer = new CarCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в Автосалон!");

        int choice;
        do {
            System.out.println("\nВыберите действие:\n1)Добавить автомобиль в Автосалон\n2)Вывести все автомобили, имеющиеся в салоне\n3)Вывести самый дорогой автомобиль\n4)Вывести самый дешевый автомобиль\n5)Добавить клиента\n6)Вывести всех клиентов Автосалона\n7)Выйти");
            choice = scanner.nextInt();
            String brand;
            String model;
            Car cheapestCar;
            switch (choice) {
                case 1:
                    System.out.println("Введите название автомобиля: ");
                    scanner.nextLine();
                    brand = scanner.nextLine();
                    System.out.println("Введите модель автомобиля: ");
                    model = scanner.nextLine();
                    System.out.println("Введите год выпуска автомобиля: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите стоимость автомобиля: ");
                    int price = scanner.nextInt();
                    System.out.println("Введите тип машины, которую хотите добавить:\n1) Добавить новый автомобиль\n2) Добавить подержанный автомобиль\n");
                    choice = scanner.nextInt();
                    int mileage;
                    switch (choice) {
                        case 1:
                            System.out.println("Введите гарантийный срок на автомобиль: ");
                            mileage = scanner.nextInt();
                            dealer.addCar(new NewCar(brand, model, year, price, mileage));
                            System.out.println("Автомобиль добавлен!");
                            continue;
                        case 2:
                            System.out.println("Введите пробег автомобиля: ");
                            mileage = scanner.nextInt();
                            dealer.addCar(new UsedCar(brand, model, year, price, mileage));
                            System.out.println("Автомобиль добавлен!");
                        default:
                            continue;
                    }
                case 2:
                    System.out.println("Отсортировать данные по:\n1) Модели\n2) Цене\n3) Году\n");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            dealer.sortByModel(dealer.getCars());
                            break;
                        case 2:
                            dealer.sortByPrice(dealer.getCars());
                            break;
                        case 3:
                            dealer.sortByYear(dealer.getCars());
                    }

                    System.out.println("Общая стоимость автосалона: $" + dealer.getTotalValue());
                    break;
                case 3:
                    cheapestCar = dealer.getMostExpensiveCar();
                    if (cheapestCar != null) {
                        System.out.println("Самый дорогой автомобиль: " + cheapestCar.toString());
                    }
                    break;
                case 4:
                    cheapestCar = dealer.getCheapestCar();
                    if (cheapestCar != null) {
                        System.out.println("Самый дешевый автомобиль: " + cheapestCar.toString());
                    }
                    break;
                case 5:
                    System.out.println("Введите Имя и Фамилию клиента: ");
                    scanner.nextLine();
                    brand = scanner.nextLine();
                    System.out.println("Введите адрес электронной почты клиента: ");
                    model = scanner.nextLine();
                    System.out.println("Введите номер телефона клиента: ");
                    String phone = scanner.nextLine();
                    dealer.addCustomer(new Customer(brand, model, phone));
                    break;
                case 6:
                    dealer.printCustomers();
                    break;
                default:
                    if (choice > 7 || choice < 0) {
                        System.out.println("Неверные данные");
                    }
            }
        } while(choice != 7);

    }
}
