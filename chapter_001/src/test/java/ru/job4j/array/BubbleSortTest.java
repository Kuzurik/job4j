package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * re-sorting program
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {

    /**
     * compares an array with a sorted array
     */

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
       BubbleSort bubbleSort = new BubbleSort();
       int[] input = new int[] {5, 1, 2, 7, 3, 6, 4, 10, 8, 9};
       int[] result = bubbleSort.sort(input);
       int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expected));
    }


}