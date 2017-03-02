package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bubble sort
 * <p>
 * Created by JP on 3/1/2017.
 */
public class BubbleSort implements SortingAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * bubbles through an array and swaps adjacent elements if the left is greater than the right
     *
     * @param array
     */
    private static void bubble(int[] array) {

        // Need to subtract 1 since I had to ArrayIndexOutOfBoundsException the hard way; derp...
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {

                swapValues(array, i, i + 1);
            }
        }

    }

    /**
     * Accepts array and swaps values of two indexes
     *
     * @param array  - array to be modified
     * @param indexA
     * @param indexB
     */
    private static void swapValues(int[] array, int indexA, int indexB) {
        final int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    @Override
    public int[] sort(int[] array) {
        LOGGER.info("sort()...");

        for (int i = 0; i < array.length; i++) {

            bubble(array);

        }

        return array.clone();
    }

}
