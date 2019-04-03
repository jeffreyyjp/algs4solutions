package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise1_1_39 {

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

    public static void random(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform((int) (Math.pow(10, 5)), (int) (Math.pow(10, 6)));
    }

    public static int experiment(int N, int T) {
        int count = 0;
        int[] arrFirst = new int[N];
        int[] arrSecond = new int[N];
        for (int i = 0; i < T; i++) {
            random(arrFirst);
            random(arrSecond);
            Arrays.sort(arrFirst);
            Arrays.sort(arrSecond);
            for (int j = 0; j < N; j++) {
                if (j != 0 && arrFirst[j] == arrFirst[j - 1]) continue;
                if (binarySearch(arrFirst[j], arrSecond) != -1)
                    count++;
            }
        }

        return count / T;
    }

    public static void main(String[] args) {
        StdOut.print("Input T for T times experiments: ");
        int T = StdIn.readInt();
        if (T <= 0) throw new IllegalArgumentException("T should be positive!");

        for (int N = (int) (Math.pow(10, 3)); N < (int) (Math.pow(10, 7)); N *= 10) {
            StdOut.printf("%7d = %d\n", N, experiment(N, T));
        }
    }
}
