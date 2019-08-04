package ru.job4j.tracker;
import java.util.*;

/**
 * Iimplementation interface Input
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConsoleInput implements Input {
 
   private Scanner scanner = new Scanner(System.in);

    /**
     * ask a question and returns the user's response
     * @param question
     * @return answer
     */

   public String ask(String question) {
	   System.out.println(question);
        return scanner.nextLine();
    }
}
