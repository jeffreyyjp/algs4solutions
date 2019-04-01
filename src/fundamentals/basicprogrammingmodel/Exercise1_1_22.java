package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_22 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int indentWidth) {
        for (int i = 0; i < indentWidth; i++)
            StdOut.print(" ");
        StdOut.printf("lo = %d, hi = %d\n", lo, hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, indentWidth + 4);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, indentWidth + 4);
        else return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = StdIn.readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
