package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class add employee to list, stores data about all employees.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MemStore implements Store {
    /**
     * Create list of employees.
     */
    private final List<Employee> employees = new ArrayList<>();

    /**
     * This method adds to list an employee.
     * @param em
     */
    public void add(Employee em) {
        this.employees.add(em);
    }

    /**
     * this method returns list 0f employees.
     * @param filter functional interface.
     * @return
     */
    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
