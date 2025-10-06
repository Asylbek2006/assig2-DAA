package assignment2_DAA.algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import assignment2_DAA.metrics.PerformanceTracker;

public class InsertionSortTest {

    @Test
    public void testSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort.sort(arr, tracker);

        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort.sort(arr, tracker);
        assertEquals(0, arr.length);
    }

    // Add more tests for edge cases...
}
