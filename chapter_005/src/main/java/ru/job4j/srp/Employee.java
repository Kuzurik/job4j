package ru.job4j.srp;

import java.util.Calendar;
import java.util.Objects;

/**
 * This class stores info about employee.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Employee {
    /**
     * Employee name;
     */
    private final String name;
    /**
     * employment date.
     */
    private final Calendar hired;
    /**
     * date of dismissal.
     */
    private final Calendar fired;
    /**
     * Salary size.
     */
    private final double salary;

    /**
     * Constructor.
     * @param name
     * @param hired
     * @param fired
     * @param salary
     */
    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Calendar getHired() {
        return hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
