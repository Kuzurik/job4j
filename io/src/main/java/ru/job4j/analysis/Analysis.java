package ru.job4j.analysis;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analysis {

    public void unavailable(String source, String target) {

        try (BufferedReader read = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean down = true;
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    if (isAvailable(line) && down) {
                        out.print(parts[1] + ";");
                        down = false;
                    }
                    if (!isAvailable(line) && !down) {
                        out.println(parts[1]);
                        down = true;
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable(String line) {
        return line.startsWith("400") || line.startsWith("500");
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./io/src/main/resources/server.log", "./io/src/main/resources/target.csv");
    }
}
