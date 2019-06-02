package ru.job4j.calculator;

/**
 * Calculate ideal weight.
 * @author Aliaksandr Kuzura.
 * @since 25.05.2019.
 * @version 1.
 */


public class Fit {

    /**
     * Ideal weight for man
     * @param height man's height
     * @return ideal weight
     */

    public double manWeight(double height) {

        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for woman
     * @param height woman's height
     * @return ideal weight
     */

    public double womanWeight(double height) {

        return (height - 110) * 1.15;

    }


}
