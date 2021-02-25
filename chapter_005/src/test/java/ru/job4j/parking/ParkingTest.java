package ru.job4j.parking;

import org.junit.Test;
import ru.job4j.parking.transport.AutoTransport;
import ru.job4j.parking.transport.Car;
import ru.job4j.parking.transport.Truck;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingTest {

    @Test
    public void whenPutTrackAndCar() {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport track = new Truck("Man", 1);
        Parking parking = new Parking(1, 1);
        parking.put(car);
        parking.put(track);
        assertThat(parking.getCars().get(0), is(car));
        assertThat(parking.getTrucks().get(0), is(track));
    }

    @Test
    public void whenNoTrackRankPutToCarParking() {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport truck = new Truck("Man", 1);
        AutoTransport truck1 = new Truck("Maz", 1);
        Parking parking = new Parking(6, 1);
        parking.put(car);
        parking.put(truck);
        parking.put(truck1);
        List<AutoTransport> carsExpected = List.of(car, truck1);
        List<AutoTransport> truckExpected = List.of(truck);
        assertThat(carsExpected, is(parking.getCars()));
        assertThat(truckExpected, is(parking.getTrucks()));

    }

    @Test (expected = ParkingException.class)
    public void whenNoParkingRanks() {
        AutoTransport car = new Car("lexus", 1);
        AutoTransport truck = new Truck("Man", 1);
        AutoTransport truck1 = new Truck("Maz", 1);
        Parking parking = new Parking(1, 1);
        parking.put(car);
        parking.put(truck);
        parking.put(truck1);
    }
}