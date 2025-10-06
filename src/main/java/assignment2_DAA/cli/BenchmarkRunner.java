package assignment2_DAA.cli;

import assignment2_DAA.algorithms.InsertionSort;
import assignment2_DAA.metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        String filename = "benchmark_results_insertion.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Algorithm,ArraySize,Comparisons,Swaps,ArrayAccesses,ExecutionTime(ms)");
        } catch (IOException e) {
            System.err.println("❌ Error creating CSV: " + e.getMessage());
            return;
        }

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            PerformanceTracker tracker = new PerformanceTracker();

            tracker.start();
            InsertionSort.sort(arr, tracker);
            tracker.stop();

            double execTime = tracker.getExecutionTimeMillis();

            saveToCSV(filename, size, tracker, execTime);

            System.out.printf("✅ Completed: size=%d | time=%.3f ms%n", size, execTime);
        }

        System.out.println("\nAll scalability benchmarks completed!");
        System.out.println("Results saved in " + filename);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    private static void saveToCSV(String filename, int size, PerformanceTracker tracker, double execTime) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.printf("%s,%d,%d,%d,%d,%.3f%n",
                    "InsertionSort",
                    size,
                    tracker.getComparisons(),
                    tracker.getSwaps(),
                    tracker.getArrayAccesses(),
                    execTime
            );
        } catch (IOException e) {
            System.err.println("❌ Error writing to CSV: " + e.getMessage());
        }
    }
}