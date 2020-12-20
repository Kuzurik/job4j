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
     * the variable stores the break to the next line.
     */

    private final String ln = System.lineSeparator();

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
                .append(ln)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(ln);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method tests a report for the developer department.
     */

    @Test
    public void whenHtmlReport() {
        ChangeFormat date = new DateFormat();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alex", now, now, 300);
        Employee worker2 = new Employee("Fedor", now, now, 400);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        DeveloperReport report = new DeveloperReport(store,date);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(ln)
                .append("<html>").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"utf-8\"/>").append(ln)
                .append("<title>Report employee</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("<table border='1'; cellpadding='10'; style='width:100%; border-radius:5px;'>").append(ln)
                .append("<tr>").append(ln)
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</th>").append(ln);
        for(Employee employee : store.findBy(em -> true)) {
            expect.append("<tr>").append(ln)
                    .append(String.format("<td>%s</td>", employee.getName()))
                    .append(String.format("<td>%s</td>",date.date(employee.getHired())))
                    .append(String.format("<td>%s</td>", date.date(employee.getFired())))
                    .append(String.format("<td>%s</td>", employee.getSalary()))
                    .append("</tr>").append(ln);
        }
        expect.append("</table>").append(ln)
                .append("</body>").append(ln)
                .append("</html>");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method tests a report for the accounting department.
     */

    @Test
    public void whenSalaryConvertToDollar() {
        Converter convert = new ConvertToDollar();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 76);
        store.add(worker);
        AccountingDepartmentReport engine = new AccountingDepartmentReport(store,convert);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(ln)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("1.0$").append(";")
                .append(ln);
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
                .append("Name; Salary;").append(ln)
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";").append(ln);
        expect.append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";").append(ln);
        expect.append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";").append(ln);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * this method test a report in json format.
     */


    @Test
    public void whenGeneratedJSONReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report jsonReport = new JsonReport(store);
        StringBuilder expect = new StringBuilder()
                .append("{").append(ln)
                .append("\"Name\" : \"").append(worker.getName()).append("\",").append(ln)
                .append("\"Hired\" : \"").append(worker.getHired().getTime()).append("\",").append(ln)
                .append("\"Fired\" : \"").append(worker.getFired().getTime()).append("\",").append(ln)
                .append("\"Salary\" : \"").append(worker.getSalary()).append("\"").append(ln)
                .append("}");
        assertThat(jsonReport.generate(employee -> true), is(expect.toString()));
    }

    /**
     * this method test a report in xml format.
     */

    @Test
    public void whenGeneratedXMLReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report xmlReport = new XmlReport(store);
        StringBuilder expect = new StringBuilder()
                .append("?<xml version=\"1.0\" encoding=\"UNF-8\"?>").append(ln)
                .append("<employee>").append(ln)
                .append("<name>").append(worker.getName()).append("</name>").append(ln)
                .append("<hired>").append(worker.getHired().getTime()).append("</hired>").append(ln)
                .append("<fired>").append(worker.getFired().getTime()).append("</fired>").append(ln)
                .append("<salary>").append(worker.getSalary()).append("</salary>").append(ln)
                .append("</employee>");
        assertThat(xmlReport.generate(employee -> true), is(expect.toString()));
    }
}
