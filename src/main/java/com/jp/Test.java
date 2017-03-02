package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Test class
 * <p>
 * Created by JP on 3/1/2017.
 */
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    private static final Random r = new Random();

    public static void main(String[] args) {

        //Select algorithm
        SortingAlgorithm algorithm = new BubbleSort();

        int[] beforeSort = generateArray();
        LOGGER.info("Before : {}", stringify(beforeSort));

        // Sort
        int[] result = algorithm.sort(beforeSort);
        LOGGER.info("After : {}", stringify(result));
    }


    private static int[] generateArray() {
        int arraySize = r.nextInt(20);
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }

    private static String stringify(int[] array) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }
}
