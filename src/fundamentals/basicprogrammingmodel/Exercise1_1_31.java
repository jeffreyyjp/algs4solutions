package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_31 {

    public static void draw(int N, double p) {
        StdDraw.setXscale(-2.0, 2.0);
        StdDraw.setYscale(-2.0, 2.0);
        StdDraw.setPenRadius(.05);

        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++) {
            d[i][0] = Math.cos(2.0 * Math.PI * i / N);
            d[i][1] = Math.sin(2.0 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p))
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
            }
        }
    }

    public static void main(String[] args) {
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        StdOut.print("Input p: ");
        double p = StdIn.readDouble();
        if (N <= 0 || (p < 0 || p > 1))
            throw new IllegalArgumentException("N should be positive, and p should between 0 and 1");

        draw(N, p);
    }
}
