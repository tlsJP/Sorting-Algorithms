package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bubble sort
 *
 * Created by JP on 3/1/2017.
 */
public class BubbleSort implements SortingAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * bubbles through an array and swaps adjacent elements if the left is greater than the right
     *
     * @param array
     */
    private void bubble(int[] array) {

        int temp;
        // Need to subtract 1 since I had to ArrayIndexOutOfBoundsException the hard way; derp...
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

    }

    @Override
    public int[] sort(int[] array) {
        LOGGER.info("sort()...");


//        for (int i = 0; i < unsortedArray.length; i++) {

        bubble(array);

//        }


        return array.clone();
    }

}
