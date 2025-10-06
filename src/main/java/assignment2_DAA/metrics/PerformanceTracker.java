package assignment2_DAA.metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }

    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }

    public void incrementArrayAccesses() { arrayAccesses++; }

    public long getArrayAccesses() { return arrayAccesses; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }

    public double getExecutionTimeMillis() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }
}