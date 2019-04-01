package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_1_28 {

    public static int rank(int key, int[] a) {
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

    /**
     * Remove dumplicated elements in sorted array.
     *
     * @param whitelist An sorted array.
     * @return A new array contains unique elements.
     */
    public static int[] removeDuplicates(int[] whitelist) {
        int[] newWhiteList = new int[whitelist.length];
        int count = 0;
        newWhiteList[0] = whitelist[0];
        for (int i = 1; i < whitelist.length; i++) {
            if (whitelist[i] != newWhiteList[count]) {
                count++;
                newWhiteList[count] = whitelist[i];
            }
        }
        count++;
        int[] compactWhiteList = new int[count];
        System.arraycopy(newWhiteList, 0, compactWhiteList, 0, count);

        return compactWhiteList;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);

        int[] compactWhiteList = removeDuplicates(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, compactWhiteList) == -1)
                StdOut.println(key);
        }
    }
}
