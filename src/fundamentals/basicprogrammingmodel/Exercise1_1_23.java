package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_23 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (lo + hi) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        String tag = StdIn.readString();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1) {
                if ("-".equals(tag)) continue;
            } else {
                if ("+".equals(tag)) continue;
            }
            StdOut.println(key);
        }
    }
}
