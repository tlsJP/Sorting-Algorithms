package com.jp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jp.Test.stringify;

/**
 * Insertion sort
 * <p>
 * Created by JP on 3/1/2017.
 */
public class InsertionSort implements SortingAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public int[] sort(int[] array) {
        LOGGER.info("sort() - array length : {}", array.length);

        for (int i = 0; i < array.length; i++) {

            LOGGER.debug("Current array : {}",stringify(array));

            // The suspect is the value we are currently investigating.
            // We copy the index so we can manipulate it for the purpose of inserting other values from the array.
            int suspect = array[i];
            int insertionIndex = i;
            LOGGER.debug("Suspect : {} @ {}", suspect,insertionIndex);

            // At this point we're just trying to find a home for our suspect
            // I learned how to ArrayIndexOutOfBoundsException again!  make sure :: index > 0 ; derp...
            while (insertionIndex > 0 && suspect < array[insertionIndex - 1]) {

                LOGGER.debug("Shifting...");

                // Since the suspect is greater than the one to the left, we'll just move the left value into
                // the spot where the suspect lives
                array[insertionIndex] = array[insertionIndex - 1];

                // At this point there is no place for the suspect to go, so we'll make his potential new home
                // The now 'vacant' spot.
                insertionIndex--;
            }

            // By this time, the insertionIndex should be low enough in the array that putting our suspect
            // in that spot means that everything to the left of the suspect is less than the suspect
            array[insertionIndex] = suspect;

        }

        return array;
    }
}
