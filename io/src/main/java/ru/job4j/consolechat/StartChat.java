package ru.job4j.consolechat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Start console chat
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartChat {
    private final static String STOP = "stop";
    private final static String CONTINUE = "continue";
    private final static String EXIT = "exit";

    /**
     * Save answers to list
     * @return random answer
     */

    public String answer() {
        List<String> answers = GetAnswers.answers("io/src/main/resources/questions.txt");
        return answers.get(new Random().nextInt(answers.size()));
    }

    /**
     *  Logic console chat
     */

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<String> log = new ArrayList<>();
        String userMsg;
        String botMsg;
        boolean stop = true;
        do {
            userMsg = scanner.nextLine();
            log.add("user: " + userMsg);
            if (STOP.equals(userMsg)) {
                stop = false;
            }
            if (CONTINUE.equals(userMsg)) {
                stop = true;
            }
            if (stop && !EXIT.equals(userMsg)) {
                botMsg = this.answer();
                log.add("bot: " + botMsg);
                System.out.println(botMsg);
            }

        } while (!EXIT.equals(userMsg));
        WriteLog.writeLog(log, "io/src/main/resources/log.txt");


    }


    public static void main(String[] args) {
        new StartChat().start();
    }
}
