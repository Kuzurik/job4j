package ru.job4j.consolechat;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Write log to file
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class WriteLog {

    /**
     * Write text from list to file txt
     * @param log - List log
     * @param target - path to file txt
     */

    public static void writeLog(List<String> log, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String value : log) {
                out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
