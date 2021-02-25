package ru.job4j.parking;

import ru.job4j.parking.transport.AutoTransport;

import java.util.ArrayList;
import java.util.List;

public class Parking  {
    private final List<AutoTransport> cars = new ArrayList<>();
    private final List<AutoTransport> trucks = new ArrayList<>();
    private final int carNumber;
    private final int truckNumber;


    public Parking(int carNumber, int trackNumber) {
        this.carNumber = carNumber;
        this.truckNumber = trackNumber;
    }

    public boolean put(AutoTransport auto) {

        return false;
    }

    public List<AutoTransport> getCars() {
        return cars;
    }

    public List<AutoTransport> getTrucks() {
        return trucks;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "cars=" + cars +
                ", trucks=" + trucks +
                '}';
    }
}