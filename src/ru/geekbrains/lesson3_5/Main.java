package ru.geekbrains.lesson3_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Машинка1");
        Car car2 = new Car("Машинка2");
        Car car3 = new Car("Машинка3");
        Car car4 = new Car("Машинка4");
        Truck truck1 = new Truck("Грузовик1");
        Truck truck2 = new Truck("Грузовик2");
        Truck truck3 = new Truck("Грузовик3");
        Bus bus1 = new Bus("Автобус1");
        Bus bus2 = new Bus("Автобус2");
        Bus bus3 = new Bus("Автобус3");

        GasStation gasStation = new GasStation();

        ExecutorService executorService  = Executors.newFixedThreadPool(10);

        executorService.execute(() -> driving(car1, gasStation));
        executorService.execute(() -> driving(car2, gasStation));
        executorService.execute(() -> driving(car3, gasStation));
        executorService.execute(() -> driving(car4, gasStation));
        executorService.execute(() -> driving(truck1, gasStation));
        executorService.execute(() -> driving(truck2, gasStation));
        executorService.execute(() -> driving(truck3, gasStation));
        executorService.execute(() -> driving(bus1, gasStation));
        executorService.execute(() -> driving(bus2, gasStation));
        executorService.execute(() -> driving(bus3, gasStation));

        executorService.shutdown();
    }

    private static void driving(Vehicle vehicle, GasStation gasStation) {
        while (true) {
            vehicle.drive();
            gasStation.enter(vehicle);
        }
    }

}
