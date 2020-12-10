package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * this class tests all reports for departments.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ReportEngineTest {
    /**
     * this method tests first method of report.
     */
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method tests a report for the developer department.
     */

    @Test
    public void whenHtmlReport() {
        String lS = System.lineSeparator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alex", now, now, 300);
        Employee worker2 = new Employee("Fedor", now, now, 400);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        DeveloperReport report = new DeveloperReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(lS)
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
        for(Employee employee : store.findBy(em -> true)) {
            expect.append("<tr>").append(lS)
                    .append(String.format("<td>%s</td>", employee.getName()))
                    .append(String.format("<td>%s</td>", DateFormat.date(employee.getHired())))
                    .append(String.format("<td>%s</td>", DateFormat.date(employee.getFired())))
                    .append(String.format("<td>%s</td>", employee.getSalary()))
                    .append("</tr>").append(lS);
        }
        expect.append("</table>").append(lS)
                .append("</body>").append(lS)
                .append("</html>");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method tests a report for the accounting department.
     */

    @Test
    public void whenSalaryConvertToDollar() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 76);
        store.add(worker);
        AccountingDepartmentReport engine = new AccountingDepartmentReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("1.0$").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method test a report for the HR department.
     */

    @Test
    public void whenSalaryMaxToMin() {
        SortingStore store = new SortingStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alex", now, now, 300);
        Employee worker2 = new Employee("Fedor", now, now, 400);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        HRDepartmentReport engine = new HRDepartmentReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";").append(System.lineSeparator());
        expect.append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";").append(System.lineSeparator());
        expect.append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
