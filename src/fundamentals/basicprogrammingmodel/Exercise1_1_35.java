package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_35 {
    private final static int SIDES = 6;

    /**
     * Compute possibility of each sum of two dict.
     *
     * @return array holding the possibility.
     */
    public static double[] simulate() {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    /**
     * Actual experiment for dist simulation.
     *
     * @param N total experiment times
     * @return array holding the experiment results.
     */
    public static double[] distExperiment(int N) {
        double[] dist = new double[2 * SIDES + 1];
        int diceFirst;
        int diceSecond;
        int sum;
        for (int i = 0; i < N; i++) {
            diceFirst = StdRandom.uniform(1, 7);
            diceSecond = StdRandom.uniform(1, 7);
            sum = diceFirst + diceSecond;
            dist[sum]++;
        }

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= N;

        return dist;
    }

    public static void main(String[] args) {
        double[] exactDist = simulate();
        StdOut.println("Exact possibility of dist simulation.");
        for (int i = 2; i < exactDist.length; i++)
            StdOut.printf("(%d = %5.3f) ", i, exactDist[i]);
        StdOut.println();

        StdOut.print("Input N for count of experiments: ");
        int N = StdIn.readInt();
        if (N <= 0) throw new IllegalArgumentException("N should be positive!");

        double[] experimentDist = distExperiment(N);
        StdOut.println("Experiment N times of dist simulation.");
        for (int i = 2; i < experimentDist.length; i++)
            StdOut.printf("(%d = %5.3f) ", i, experimentDist[i]);
    }
}
