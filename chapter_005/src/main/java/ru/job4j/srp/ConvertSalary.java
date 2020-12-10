package ru.job4j.srp;

/**
 * This class convert salary to dollar.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConvertSalary {
    /**
     * The method get rub and convert to dollar.
     * @param rub
     * @return
     */
    public static String convert(double rub) {
        return String.format("%s$", rub / 76);
    }
}
