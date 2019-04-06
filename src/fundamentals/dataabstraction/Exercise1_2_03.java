package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.*;

import java.util.HashMap;
import java.util.Map;

public class Exercise1_2_03 {

    private static Map<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    public static void drawIntervals(Interval2D[] intervals, double min, double max) {
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        int N = intervals.length;
        for (int i = 0; i < N; i++) {
            Interval1D x = createRandomInterval1D(min, max);
            Interval1D y = createRandomInterval1D(min, max);
            intervals[i] = new Interval2D(x, y);
            intervalMap.put(intervals[i], new Interval1D[]{x, y});
            intervals[i].draw();
        }
    }

    public static Interval1D createRandomInterval1D(double min, double max) {
        double left = StdRandom.uniform(min, max);
        double right = StdRandom.uniform(min, max);
        if (left > right) {
            double temp = left;
            left = right;
            right = temp;
        }

        return new Interval1D(left, right);
    }

    public static int countIntersects(Interval2D[] intervals) {
        int sum = 0;
        int N = intervals.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j]))
                    sum++;
            }
        }

        return sum;
    }

    public static int countContains(Interval2D[] intervals) {
        int sum = 0;
        int N = intervals.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (contains(intervals[i], intervals[j]))
                    sum++;
            }
        }

        return sum;
    }

    private static boolean contains(Interval2D x, Interval2D y) {
        Interval1D[] intervalsFirst = intervalMap.get(x);
        Interval1D[] intervalsSecond = intervalMap.get(y);
        double firstXMin = intervalsFirst[0].min();
        double firstXMax = intervalsFirst[0].max();
        double firstYMin = intervalsFirst[1].min();
        double firstYMax = intervalsFirst[1].max();
        double secondXMin = intervalsSecond[0].min();
        double secondXMax = intervalsSecond[0].max();
        double secondYMin = intervalsSecond[1].min();
        double secondYMax = intervalsSecond[1].max();

        if (firstXMin <= secondXMin && firstXMax >= secondXMax && firstYMin <= secondYMin && firstYMax >= secondYMax)
            return true;
        return firstXMin >= secondXMin && firstXMax <= secondXMax && firstYMin >= secondYMin && firstYMax <= secondYMax;
    }

    public static void main(String[] args) {
        StdOut.print("Input N for total Interval2Ds: ");
        int N = StdIn.readInt();
        if (N <= 1) throw new IllegalArgumentException("N should be greater than 1!");

        StdOut.print("Input min: ");
        double min = StdIn.readDouble();
        StdOut.print("Input max: ");
        double max = StdIn.readDouble();
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }

        Interval2D[] intervals = new Interval2D[N];
        drawIntervals(intervals, min, max);
        StdOut.printf("Number of pairs of intervals that intersect is %d\n", countIntersects(intervals));
        StdOut.printf("Number of intervals that are contained in one another is %d\n", countContains(intervals));
    }
}
