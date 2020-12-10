package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * Creates a link to the generate method.
 */

public interface Report {

    /**
     * generate method reference.
     * @param filter functional interface.
     * @return String.
     */
    String generate(Predicate<Employee> filter);
}
