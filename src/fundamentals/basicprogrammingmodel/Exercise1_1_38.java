package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_38 {

    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static int bruteForceSearch(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = StdIn.readAllInts();

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            long startTime = System.nanoTime();
            if (binarySearch(key, whitelist) == -1)
                StdOut.println(key);
            long endTime = System.nanoTime();
            StdOut.printf("Duration for binary search is %d\n", endTime - startTime);
        }

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            long startTime = System.nanoTime();
            if (bruteForceSearch(key, whitelist) == -1)
                StdOut.println(key);
            long endTime = System.nanoTime();
            StdOut.printf("Duration for binary search is %d\n", endTime - startTime);
        }
    }
}
