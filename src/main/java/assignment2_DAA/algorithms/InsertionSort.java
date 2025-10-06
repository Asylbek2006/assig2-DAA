package assignment2_DAA.algorithms;

import assignment2_DAA.metrics.PerformanceTracker;

public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            tracker.incrementArrayAccesses();

            while (j >= 0 && arr[j] > key) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses();
                arr[j + 1] = arr[j];
                tracker.incrementArrayAccesses();
                j = j - 1;
            }

            arr[j + 1] = key;
            tracker.incrementSwaps();
            tracker.incrementArrayAccesses();
        }
    }
}