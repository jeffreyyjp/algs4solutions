package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_10 {

    public static void main(String[] args) {
        StdOut.print("Input N for total operations: ");
        int N = StdIn.readInt();
        StdOut.print("Input max for absolute value of count: ");
        int max = StdIn.readInt();
        if (N <= 0 || max <= 0) throw new IllegalArgumentException("N and max should be positive!");
        VisualCounter counter = new VisualCounter("counter", N, max);
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli())
                counter.increment();
            else counter.decrement();
        }
        StdOut.print(counter);
    }
}
