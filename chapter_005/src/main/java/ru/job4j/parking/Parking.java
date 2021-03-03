package ru.job4j.parking;

import ru.job4j.parking.transport.AutoTransport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Parking {
    private final List<AutoTransport> cars = new ArrayList<>();
    private final List<AutoTransport> trucks = new ArrayList<>();
    private int carNumber;
    private int truckNumber;

    /**
     * constructor that takes values of the number of places for cars and trucks
     * @param carNumber
     * @param truckNumber
     */
    public Parking(int carNumber, int truckNumber) {
        this.carNumber = carNumber;
        this.truckNumber = truckNumber;
    }

    /**
     * Distributes transport.
     * @param auto
     * @throws ParkingException
     */

    public void put(AutoTransport auto) throws ParkingException {
        if (isCar(auto)) {
            if (!checkCarNumber(auto)) {
                throw new ParkingException("Not enough car parking spaces");
            } else {
                cars.add(auto);
                carNumber = carNumber - auto.getSize();
            }
        }
        if (!isCar(auto)) {
            if (!checkTruckNumber(auto)) {
                throw new ParkingException("Not enough truck and car parking spaces");
            }
            if (truckNumber > 0) {
                trucks.add(auto);
                truckNumber --;
            } else {
                cars.add(auto);
                carNumber = carNumber - auto.getSize();
            }

        }
    }

    /**
     * check the number of car parking spaces.
     * @param auto
     * @return
     */

    public boolean checkCarNumber(AutoTransport auto) {
        return isCar(auto) && carNumber > 0;
    }

    /**
     * checks the number of truck parking spaces.
     * @param auto
     * @return
     */

    public boolean checkTruckNumber(AutoTransport auto) {
        return !isCar(auto) && truckNumber > 0 || carNumber - auto.getSize() >= 0;
    }

    /**
     * checks if the transport is a car.
     * @param auto
     * @return
     */

    public boolean isCar(AutoTransport auto) {
        return auto.getSize() == 1;
    }

    public List<AutoTransport> getCars() {
        return cars;
    }

    public List<AutoTransport> getTrucks() {
        return trucks;
    }
}