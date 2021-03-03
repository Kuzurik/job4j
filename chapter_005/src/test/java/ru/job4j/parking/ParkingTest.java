package ru.job4j.parking;

import org.junit.Test;
import ru.job4j.parking.transport.AutoTransport;
import ru.job4j.parking.transport.Car;
import ru.job4j.parking.transport.Truck;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ParkingTest {

    /**
     * Test when add one car and one truck.
     * @throws ParkingException
     */

    @Test
    public void whenPutTrackAndCar() throws ParkingException {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport track = new Truck("Man", 2);
        Parking parking = new Parking(1, 1);
        parking.put(car);
        parking.put(track);
        assertThat(parking.getCars().get(0), is(car));
        assertThat(parking.getTrucks().get(0), is(track));
    }

    /**
     * Test add car to car parking and truck to truck parking and truck to car parking.
     * @throws ParkingException
     */

    @Test
    public void whenNoTrackRankPutToCarParking() throws ParkingException {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport truck = new Truck("Man", 2);
        AutoTransport truck1 = new Truck("Maz", 2);
        Parking parking = new Parking(6, 1);
        for (AutoTransport autoTransport : List.of(car, truck, truck1)) {
            parking.put(autoTransport);
        }
        List<AutoTransport> carsExpected = List.of(car, truck1);
        List<AutoTransport> truckExpected = List.of(truck);
        assertThat(parking.getCars(), is(carsExpected));
        assertThat(parking.getTrucks(), is(truckExpected));

    }

    /**
     * when we get the exception.
     * @throws ParkingException
     */

    @Test (expected = ParkingException.class)
    public void whenNoParkingRanks() throws ParkingException {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport truck = new Truck("Man", 2);
        AutoTransport truck1 = new Truck("Maz", 2);
        Parking parking = new Parking(1, 1);
        parking.put(car);
        parking.put(truck);
        parking.put(truck1);
    }
}