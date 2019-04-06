package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_2_09 {

    public static int rank(int key, int[] a, Counter counter) {
        counter.increment();
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

    public static void main(String[] args) {
        int[] whitelist = StdIn.readAllInts();
        Counter counter = new Counter("search");
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist, counter) < 0)
                StdOut.println(key);
        }

        StdOut.printf("Total checked keys is %d\n", counter.tally());
    }
}
