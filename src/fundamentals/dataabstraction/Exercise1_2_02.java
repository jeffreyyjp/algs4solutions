package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_02 {

    public static void calculateIntersects(Interval1D[] intervals) {
        int N = intervals.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j]))
                    StdOut.printf("%s is intersect with %s\n", intervals[i], intervals[j]);
            }
        }
    }

    public static void main(String[] args) {
        StdOut.print("Input N for total intervals(each defined by a pair of double values): ");
        int N = StdIn.readInt();
        if (N <= 1) throw new IllegalArgumentException("N should be greater than 1!");

        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            StdOut.print("Input min value: ");
            double min = StdIn.readDouble();
            StdOut.print("Input max value: ");
            double max = StdIn.readDouble();
            intervals[i] = new Interval1D(min, max);
        }

        calculateIntersects(intervals);
    }
}
