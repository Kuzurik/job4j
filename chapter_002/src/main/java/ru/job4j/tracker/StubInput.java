package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, List<Integer> range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }

}
