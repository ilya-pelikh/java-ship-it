package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Parcel> allParcels = new ArrayList<>();

    private static List<Trackable> allTrackingParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> standartParcelsPacked = new ParcelBox<>(1000);
    private static ParcelBox<FragileParcel> fragileParcelsPacked = new ParcelBox<>(1000);
    private static ParcelBox<PerishableParcel> perishableParcelsPacked = new ParcelBox<>(1000);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить адрес доставки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void showBox () {
        System.out.println("Выберите тип коробоки: ");
        System.out.println("""
                1. Стандартная
                2. Хрупкая
                3. Со сроком годности
                """);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println(standartParcelsPacked.getAllParcels());
                break;
            case 2:
                System.out.println(fragileParcelsPacked.getAllParcels());
                break;
            case 3:
                System.out.println(perishableParcelsPacked.getAllParcels());
                break;
            default:
                System.out.println("Такого списка нет");
        }
    }

    private static void reportStatus () {
        System.out.println("Введите локацию");
        String newLocation = scanner.nextLine();

        for(Trackable trackingParcel: allTrackingParcels ) {
            trackingParcel.reportStatus(newLocation);
        }
    }

    private static void addParcel() {
        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите дату отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        System.out.println("""
                Выберите тип посылки:
                1. Стандартная
                2. Хрупкая
                3. Со сроком годности
                """);
        int choice = Integer.parseInt(scanner.nextLine());

        Parcel parcel;
        switch (choice) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standartParcelsPacked.addParcel((StandardParcel) parcel);
                break;
            case 2:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                fragileParcelsPacked.addParcel((FragileParcel) parcel);
                break;
            case 3:
                System.out.println("Введите срок годности: ");
                int timeToLive = scanner.nextInt();
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelsPacked.addParcel((PerishableParcel) parcel);
                break;
            default:
                System.out.println("Такого типа не существует");
                return;

        }

        if (parcel instanceof Trackable) {
            allTrackingParcels.add((Trackable) parcel);
        }

        allParcels.add(parcel);
    }

    private static void sendParcels() {
        for(Parcel parcel : allParcels) {
            System.out.println("-> " + parcel.description);
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        for(Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println(sum);
    }

}

