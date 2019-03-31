package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_14 {

    /**
     * Get the largest integer value no larger than the base-2 logarithm of N.
     *
     * @param N positive integer.
     * @return largest integer value no larger than the base-2 logarithm of N.
     */
    public static int lg(int N) {
        int base = 2;
        int count = -1;
        for (int temp = 1; temp <= N; temp *= base) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        StdOut.print("Please input a positive integer: ");
        int N = StdIn.readInt();
        if (0 >= N)
            throw new IllegalArgumentException("N should be positive!");
        StdOut.printf(
                "The largest integer value no larger than the base-2 logarithm of %d is %d",
                N, lg(N));

    }
}
