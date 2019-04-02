package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_32 {

    public static void draw(double[] a, int N, double l, double r) {
        if (N <= 0 || l >= r)
            throw new IllegalArgumentException();

        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, a.length);
        double interval = (r - l) / N;
        int[] count = new int[N];
        int index;
        for (double item : a) {
            if (item < l || item >= r) continue;
            index = (int) ((item - l) / interval);
            count[index]++;
        }

        for (int i = 0; i < N; i++) {
            double x = l + (0.5 + i) * interval;
            double y = count[i] / 2.0;
            double rw = interval / 2.0;
            double rh = count[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void main(String[] args) {
        double[] a = new double[50];
        for (int i = 0; i < 50; i++) {
            a[i] = StdRandom.uniform(0.0, 10.0);
        }

        StdOut.print("Input N for total count of histogram: ");
        int N = StdIn.readInt();
        StdOut.print("Input left value: ");
        double l = StdIn.readDouble();
        StdOut.print("Input right value: ");
        double r = StdIn.readDouble();

        draw(a, N, l, r);
    }
}
