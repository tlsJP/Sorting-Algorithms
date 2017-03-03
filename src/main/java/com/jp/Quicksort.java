package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jp.Helper.stringify;
import static com.jp.Helper.swapValues;

/**
 * Created by JP on 3/1/2017.
 */
public class Quicksort implements SortingAlgorithm {
    private static final Logger LOGGER = LoggerFactory.getLogger(Quicksort.class);

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex >= rightIndex) {
            return;
        }

        int partitionIndex = hoarePartition(array, leftIndex, rightIndex);
        LOGGER.info("p={}", partitionIndex);

        LOGGER.info("Doing left partition...  [{},{}]", leftIndex, partitionIndex);
        quickSort(array, leftIndex, partitionIndex);

        LOGGER.info("Doing right partition...  [{},{}]", partitionIndex + 1, rightIndex);
        quickSort(array, partitionIndex + 1, rightIndex);

    }

    /**
     * Hoare method of partitioning of a quicksort
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return - the index of the new pivot point
     */
    private static int hoarePartition(int[] array, int leftIndex, int rightIndex) {

        int pivotValue = array[rightIndex];

        int leftPointer = leftIndex;
        int rightPointer = rightIndex-1;

        // We will loop until the two indexes meet
        while (leftPointer <= rightPointer) {

            // Start by moving the left index to the right until we find a value >= pivotValue
            while (array[leftPointer] < pivotValue) {
                leftPointer++;
            }

            // Next let's move the right index to the left until we find value <= pivotValue
            while (array[rightPointer] > pivotValue && rightPointer > 0) {
                rightPointer--;
            }

            // The two pointers have met, so we just need to swap the pivot value into place and return the pointer
            if (leftPointer >= rightPointer) {
                swapValues(array, leftPointer, rightIndex);
                return rightPointer;
            }

            if (array[leftPointer] > array[rightPointer]) {
                swapValues(array, leftPointer, rightPointer);
            }

            LOGGER.info("{}", stringify(array));
        }

        LOGGER.info("am i supposed to be here??");
        return leftPointer;


    }

    @Override
    public int[] sort(int[] array) {
        LOGGER.info("sort({})", array.length);

        quickSort(array, 0, array.length - 1);

        return array;
    }
}
