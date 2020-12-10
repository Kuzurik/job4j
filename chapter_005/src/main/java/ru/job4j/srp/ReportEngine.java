package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ReportEngine implements Report{
    /**
     * Stores the object.
     */
    private final Store store;

    /**
     * Constructor takes a Store object.
     * @param store
     */
    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * The method creates a line that outputs a report.
     * @param filter functional interface.
     * @return
     */

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for(Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
