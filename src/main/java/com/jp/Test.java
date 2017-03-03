package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jp.Helper.generateArray;
import static com.jp.Helper.stringify;

/**
 * Test class
 * <p>
 * Created by JP on 3/1/2017.
 */
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {

        //Select algorithm
        SortingAlgorithm algorithm = new Quicksort();

        int[] beforeSort = generateArray();
        LOGGER.info("Before : {}", stringify(beforeSort));

        // Sort
        int[] result = algorithm.sort(beforeSort);
        LOGGER.info("After : {}", stringify(result));
    }


}
