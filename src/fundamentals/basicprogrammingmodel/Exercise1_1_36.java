package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_36 {

    /**
     * Randomly shuffle an array.
     *
     * @param a one-dimensional array.
     */
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    /**
     * Reset array then a[i] = i.
     *
     * @param a one-dimensional array.
     */
    public static void reset(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = i;
    }

    /**
     * Randomly shuffle array a N times, reset before each shuffles.
     *
     * @param a one-dimensional array.
     * @param N total times to shuffle.
     * @return M×M table such that row i gives the number of times i wound up in position j for all j.
     */
    public static int[][] doShuffle(int[] a, int N) {
        int len = a.length;
        int[][] result = new int[len][len];
        for (int i = 0; i < N; i++) {
            reset(a);
            shuffle(a);
            for (int j = 0; j < len; j++) {
                result[a[j]][j]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StdOut.print("Input M for length of array a: ");
        int M = StdIn.readInt();
        StdOut.print("Input N to do N shuffles for the array: ");
        int N = StdIn.readInt();
        if (M <= 0 || N <= 0) throw new IllegalArgumentException("M and N should be positive!");

        int[] a = new int[M];
        int[][] result = doShuffle(a, N);
        StdOut.println("row i gives the number of times i wound up in position j for all j");
        for (int[] items : result) {
            for (int subItem : items)
                StdOut.printf("%d ", subItem);
            StdOut.println();

        }
    }
}
