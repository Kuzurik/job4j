package ru.job4j.converter;

/**
 * Calculate.
 * @author Aliaksandr Kuzura.
 * @since 25.05.2019.
 * @version 1.
 */



public class Converter {

    /**
     *  Convert rubles to euros
     * @param value ruble
     * @return euro
     */

    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Convert rubles to dollars
     * @param value ruble
     * @return euro
     */

    public int rubleToDollar(int value) {
        return value / 60;

    }


}
