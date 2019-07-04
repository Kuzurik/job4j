package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test merge two arrays.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MergeArraySecondTest {

    /**
     *  Compares the result with the expected array.
     */

    @Test
    public  void when2ArrayTurn1() {
        MergeArray mergeArray = new MergeArray();
        int[] left = new int[] {1, 3, 6};
        int[] right = new int[] {2, 4, 8};
        int[] result = mergeArray.merge(left, right);
        int[] expected = new int[] {1, 2, 3, 4, 6, 8};
        assertThat(result, is(expected));
    }
}
