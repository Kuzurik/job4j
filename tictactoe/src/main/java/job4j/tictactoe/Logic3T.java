package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWin(Predicate<Figure3T> predicate) {
        boolean result = false;
            for (int i = 0; i != this.table.length; i++) {
                if (this.fillBy(predicate, 0, i, 1, 0) ||
                this.fillBy(predicate, i,0,0, 1)) {
                    result = true;
                    break;
                }
            }
        return result;
    }

    public boolean isWinDiagonal(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0,0, 1, 1) ||
                this.fillBy(predicate, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerX() {
        return  isWin(Figure3T::hasMarkX) || isWinDiagonal(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO) || isWinDiagonal(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table).flatMap(Arrays::stream).anyMatch(cell -> !(cell.hasMarkX() || cell.hasMarkO()));
    }
}
