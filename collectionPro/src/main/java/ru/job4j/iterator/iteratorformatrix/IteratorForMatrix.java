package iterator.iteratorForMatrix;

import java.util.Iterator;

public class IteratorForMatrix implements Iterator<Integer> {
    private final int[][] matrix;
    private int col = 0;
    private int row = 0;

    public IteratorForMatrix(final int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return row < matrix.length && col < matrix[row].length;
    }

    @Override
    public Integer next() {
        int value = matrix[this.row][this.col];
        col++;
        if (col >= matrix[row].length){
            row++;
            col = 0;
        }
        return value;
    }
}
