package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_19 {

    /**
     * Using Recursion to compute Fibonacci sequence.
     *
     * @param N integer value to process.
     * @return result for the Fibonacci sequence.
     */
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    /**
     * Using loop to compute Fibonacci sequence.
     *
     * @param N integer value to process.
     * @return result for the Fibonacci sequence.
     */
    public static long optimizeF(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int[] temp = new int[N + 1];
        temp[1] = 1;
        for (int i = 2; i <= N; i++)
            temp[i] = temp[i - 1] + temp[i - 2];
        return temp[N];
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + optimizeF(N));
    }
}
