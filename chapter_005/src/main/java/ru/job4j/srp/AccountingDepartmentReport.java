package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report for the accounting department.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class AccountingDepartmentReport implements Report{
    /**
     * Stores the object.
     */
    private final Store store;
    private final Converter convert;
    /**
     * Constructor takes a Store object.
     * @param store
     */
    public AccountingDepartmentReport(Store store, Converter convert) {
        this.store = store;
        this.convert = convert;
    }

    /**
     * The method generates a line that outputs a report for the accounting department.
     * @param filter functional interface.
     * @return
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(convert.convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
