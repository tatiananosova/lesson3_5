package ru.geekbrains.lesson3_5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasStation {
    private ReentrantReadWriteLock lock;
    private Semaphore semaphore;

    public GasStation () {
        semaphore = new Semaphore(3);
    }

    public void enter(Vehicle vehicle) {
        try {
            System.out.println(vehicle.getName() + " is going to enter the GAS station...");
            semaphore.acquire();

            System.out.println(vehicle.getName() + " is fueling...");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(vehicle.getName() + " exit GAS station.");
        }
    }
}
