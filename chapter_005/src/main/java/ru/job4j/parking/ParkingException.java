package ru.job4j.parking;

/**
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ParkingException extends Exception{

    /**
     * Send exception message.
     * @param message
     */

    public ParkingException(String message) {
        super(message);
    }
}
