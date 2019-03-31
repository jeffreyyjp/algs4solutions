package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_20 {

    /**
     * Using recursion to compute ln(N!).
     *
     * @param N a positive integer number.
     * @return result for computation.
     */
    public static double ln(int N) {
        if (N == 1) return 0;
        return Math.log(N) + ln(N - 1);
    }

    public static void main(String[] args) {
        StdOut.print("Input a positive integer number: ");
        int N = StdIn.readInt();
        if (N <= 0)
            throw new IllegalArgumentException("N should be positive");
        StdOut.printf("Value of ln(%d!) is %f\n", N, ln(N));
    }
}
