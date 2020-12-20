package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report in json format.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class XmlReport implements Report {
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

    public XmlReport(Store store) {
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
        text.append("?<xml version=\"1.0\" encoding=\"UNF-8\"?>").append(ln)
                .append("<employee>").append(ln);
        for (Employee employee : store.findBy(filter)) {
            text.append("<name>").append(employee.getName()).append("</name>").append(ln)
                    .append("<hired>").append(employee.getHired().getTime()).append("</hired>").append(ln)
                    .append("<fired>").append(employee.getFired().getTime()).append("</fired>").append(ln)
                    .append("<salary>").append(employee.getSalary()).append("</salary>").append(ln)
                    .append("</employee>");
        }
        return text.toString();
    }
}
