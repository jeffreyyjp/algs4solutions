package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_27 {

    /**
     * Compute binomial distribution(recursion version).
     *
     * @param N counts for all operation.
     * @param k counts for successful operation.
     * @param p each individual operation's possibility.
     * @return result for computed possibility.
     */
    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        else if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    /**
     * Compute binomial distribution(non-recursion version).
     *
     * @param N counts for all operation.
     * @param k counts for successful operation.
     * @param p each individual operation's possibility.
     * @return result for computed possibility.
     */
    public static double optimizeBinomial(double[][] arr, int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        else if (N < 0 || k < 0) return 0.0;

        if (arr[N][k] == -1)
            arr[N][k] = (1.0 - p) * optimizeBinomial(arr, N - 1, k, p) + p * optimizeBinomial(arr, N - 1, k - 1, p);

        return arr[N][k];
    }

    public static void main(String[] args) {
        StdOut.print("Input N for total operations: ");
        int N = StdIn.readInt();
        StdOut.print("Input k for expected happened operations: ");
        int k = StdIn.readInt();
        double possibility = StdRandom.uniform();
        double[][] arr = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++)
                arr[i][j] = -1;
        }
        StdOut.printf("Binomial distribution for N = %d, k = %d, p = %f is %f\n", N, k, possibility,
                optimizeBinomial(arr, N, k, possibility));
    }
}
