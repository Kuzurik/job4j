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
    
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
                if (value == key) {
                    exist = true;
                    break;
                }
        }
        if (exist){
            return key;
        } else {
            throw new MenuOutException("out of menu range.");
        }

    }

}
