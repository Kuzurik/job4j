package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report for the HR department.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class HRDepartmentReport implements Report{
    /**
     * Stores the object.
     */

    private final Store store;

    /**
     * Constructor takes a Store object.
     * @param store
     */
    public HRDepartmentReport(Store store) {
        this.store = store;
    }

    /**
     * The method generates a line that outputs a report for the HR department.
     * @param filter functional interface.
     * @return
     */

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
