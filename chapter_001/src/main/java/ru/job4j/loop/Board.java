package ru.job4j.loop;

/**
 * build a chessboard in pseudo chart.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    /**
     *  build a chessboard in pseudo chart.
     * @param width Width of board.
     * @param height Height of board
     * @return a string with the construction.
     */

    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }

            screen.append(ln);
        }
        return screen.toString();
    }
}





