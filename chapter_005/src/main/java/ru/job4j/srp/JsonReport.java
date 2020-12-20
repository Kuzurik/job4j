package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report in json format.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class JsonReport implements Report{
    /**
     * Stores the object.
     */

    private final Store store;

    /**
     * the variable stores the break to the next line.
     */
    private final String ln = System.lineSeparator();

    /**
     * Constructor takes a Store object.
     * @param store
     */
    public JsonReport(Store store) {
        this.store = store;
    }

    /**
     * The method generates a line that outputs a report in json format .
     * @param filter functional interface.
     * @return
     */

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{").append(ln);
        for (Employee employee : store.findBy(filter)) {
            text.append("\"Name\" : \"").append(employee.getName()).append("\",").append(ln)
                    .append("\"Hired\" : \"").append(employee.getHired().getTime()).append("\",").append(ln)
                    .append("\"Fired\" : \"").append(employee.getFired().getTime()).append("\",").append(ln)
                    .append("\"Salary\" : \"").append(employee.getSalary()).append("\"").append(ln)
                    .append("}");
        }
        return text.toString();
    }
}
