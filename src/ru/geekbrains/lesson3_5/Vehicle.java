package ru.geekbrains.lesson3_5;

public abstract class Vehicle {
    private String name;
    private double volume;
    private double intake;

    public Vehicle(String name, double volume, double intake) {
        this.name = name;
        this.volume = volume;
        this.intake = intake;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getIntake() {
        return intake;
    }

    public void drive() {
        System.out.println(getName() + " start driving" );
        double currentVolume = getVolume();
        while (currentVolume >= intake) {
            try {
                Thread.sleep(3000);
                currentVolume = currentVolume - getIntake();
                System.out.println(getName() + " driving -> New volume = " + currentVolume);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "going to GAS station");

    }
}
