package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_29 {

    /**
     * Get the number of elements that are smaller than the key.
     *
     * @param key flag to set for compare.
     * @param a   one-dimensional sorted array.
     * @return
     */
    public static int rank(int key, int[] a) {
        int count = 0;
        for (int item : a) {
            if (item < key) count++;
            else break;
        }

        return count;
    }

    /**
     * Get the number of elements that equal to key.
     *
     * @param key flag to set for compare.
     * @param a   one-dimensional sorted array.
     * @return
     */
    public static int count(int key, int[] a) {
        int count = 0;
        for (int item : a) {
            if (item == key) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        StdOut.print("Input numbers of a array: ");
        int[] a = StdIn.readAllInts();
        StdOut.print("Input a key: ");
        int key = StdIn.readInt();

        Arrays.sort(a);
        StdOut.printf("Number of elements that are smaller than %d is %d\n", key, rank(key, a));
        StdOut.printf("Number of elements equals to %d is %d\n", key, count(key, a));
    }
}
