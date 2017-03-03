package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by JP on 3/2/2017.
 */
public final class Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    private static final Random r = new Random();

    private Helper() {
    }


    /**
     * Just prints out an array
     *
     * @param array
     * @return
     */
    public static String stringify(int[] array) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    /**
     * Accepts array and swaps values of two indexes
     *
     * @param array  - array to be modified
     * @param indexA
     * @param indexB
     */
    public static void swapValues(int[] array, int indexA, int indexB) {
        LOGGER.info("swapValues from indexes '{}' and '{}'", indexA, indexB);
        final int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }


    public static int[] generateArray() {
        int arraySize = r.nextInt(20);
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }
}
