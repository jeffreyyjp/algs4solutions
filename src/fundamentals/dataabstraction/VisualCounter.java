package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {

    private final String name;
    private int count;
    private final int maxOperations;
    private final int maxAbsoluteValue;
    private int currentOperations = 0;

    public VisualCounter(String id, int N, int max) {
        name = id;
        if (N <= 0 || max <= 0) throw new IllegalArgumentException();
        maxOperations = N;
        maxAbsoluteValue = max;
        StdDraw.setXscale(0, 2 * maxOperations);
        StdDraw.setYscale(-2 * maxAbsoluteValue, 2 * maxAbsoluteValue);
        StdDraw.setPenRadius(.01);
    }

    public void increment() {
        if (currentOperations < maxOperations && Math.abs(count) < maxAbsoluteValue) {
            currentOperations++;
            count++;
            StdDraw.point(currentOperations, count);
        }
    }

    public void decrement() {
        if (currentOperations < maxOperations && Math.abs(count) < maxAbsoluteValue) {
            currentOperations++;
            count--;
            StdDraw.point(currentOperations, count);
        }
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name;
    }
}
