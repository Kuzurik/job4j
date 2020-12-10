package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Creates a link to the findBy method.
 */

public interface Store {

    /**
     * findBy method reference.
     * @param filter functional interface.
     * @return Collection.
     */

    List<Employee> findBy(Predicate<Employee> filter);
}
