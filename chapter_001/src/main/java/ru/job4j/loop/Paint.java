package ru.job4j.loop;

import java.util.function.BiPredicate;

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
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     *  Creat right triangle
     * @param height Height triangle
     * @return single line triangle
     */


        public String rightTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= column
            );
        }

    /**
     *  Create pyramid
     * @param height Height pyramid
     * @return single line pyramid
     */


    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }


    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
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
