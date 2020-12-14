package ru.job4j.srp;

import java.util.function.Predicate;

/**
 * This class takes a parameter store object and returns a report for the developers department.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class DeveloperReport implements Report {
    /**
     * Stores the object.
     */
    private final Store store;

    /**
     * Constructor takes a Store object.
     * @param store
     */
    public DeveloperReport(Store store) {
        this.store = store;
    }

    /**
     * The method generates a HTML report that outputs for the developers department.
     * @param filter functional interface.
     * @return
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        String lS = System.lineSeparator();
        ChangeFormat change = new DateFormat();
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(lS)
                .append("<html>").append(lS)
                .append("<head>").append(lS)
                .append("<meta charset=\"utf-8\"/>").append(lS)
                .append("<title>Report employee</title>").append(lS)
                .append("</head>").append(lS)
                .append("<body>").append(lS)
                .append("<table border='1'; cellpadding='10'; style='width:100%; border-radius:5px;'>").append(lS)
                .append("<tr>").append(lS)
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</th>").append(lS);
        for(Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(lS)
                    .append(String.format("<td>%s</td>", employee.getName()))
                    .append(String.format("<td>%s</td>", change.date(employee.getHired())))
                    .append(String.format("<td>%s</td>", change.date(employee.getFired())))
                    .append(String.format("<td>%s</td>", employee.getSalary()))
                    .append("</tr>").append(lS);
        }
        text.append("</table>").append(lS)
                .append("</body>").append(lS)
                .append("</html>");
        return text.toString();
    }
}
