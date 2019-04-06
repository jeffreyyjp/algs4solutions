package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_01 {

    public static double shortestDistance(Point2D[] points) {
        double shortestDistance = points[0].distanceTo(points[1]);
        int N = points.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < shortestDistance)
                    shortestDistance = distance;
            }
        }

        return shortestDistance;
    }

    public static void main(String[] args) {
        StdOut.print("Input N for total N points: ");
        int N = StdIn.readInt();
        if (N <= 1) throw new IllegalArgumentException("N should be greater than 1!");

        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        }

        StdOut.printf("The shortest distance of random two points is %f\n", shortestDistance(points));
    }
}
