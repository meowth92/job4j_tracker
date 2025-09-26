package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("The bus is moving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Passengers: " + count);
    }

    @Override
    public int refuel(int fuel) {
        return fuel;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.move();
        bus.passengers(10);
        System.out.println("Fuel: " + bus.refuel(100));
    }
}
