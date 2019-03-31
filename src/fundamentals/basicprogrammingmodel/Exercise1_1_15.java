package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_15 {

    /**
     * Get a new array whose value is the i-th value's appearance count.
     *
     * @param a a one-dimensional int array.
     * @param M a positive integer number.
     * @return new array whose value is the i-th value's appearance count.
     */
    public static int[] histogram(int[] a, int M) {
        int[] newArr = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == a[j])
                    newArr[i]++;
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        StdOut.println("Input an int array: ");
        int[] a = StdIn.readAllInts();
        StdOut.print("Input a positive integer: ");
        int M = StdIn.readInt();
        if (0 >= M)
            throw new IllegalArgumentException("M should be positive");

        StdOut.printf("The histogram of a is %s\n",
                Arrays.toString(histogram(a, M)));
    }
}
