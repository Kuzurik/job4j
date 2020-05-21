package analysis;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AnalysisTest {
    private Analysis analysis;

    @Before
    public void init() {
       this.analysis = new Analysis();
    }

    @Test
    public void whenServerUnavailable() {
        String source = "../io/src/main/resources/server.log";
        String target = "../io/src/main/resources/target.csv";
        this.analysis.unavailable(source, target);
        try (Scanner scanner = new Scanner(new File(target))) {
            while (scanner.hasNext()) {
                assertEquals(scanner.nextLine(), "10:57:01;10:59:01");
                assertEquals(scanner.nextLine(), "11:01:02;11:02:02");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
