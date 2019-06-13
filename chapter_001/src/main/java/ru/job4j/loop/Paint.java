package ru.job4j.loop;

/**
 * Build a pyramid in pseudographics
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

    /**
     *  Creat left triangle
     * @param height Height triangle
     * @return single line triangle
     */

    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     *  Creat right triangle
     * @param height Height triangle
     * @return single line triangle
     */

    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
             for (int column = 0; column != width; column++) {
                 if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     *  Create pyramid
     * @param height Height pyramid
     * @return single line pyramid
     */


    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

}
