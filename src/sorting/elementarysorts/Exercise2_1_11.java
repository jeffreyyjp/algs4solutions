package sorting.elementarysorts;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2_1_11 extends Example {

    public static int getLength(int n) {
        int length = 1;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
            length++;
        }
        return length;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int[] incrementSequence = new int[getLength(N)];
        incrementSequence[0] = 1;
        for (int i = 1; i < incrementSequence.length; i++) {
            incrementSequence[i] = incrementSequence[i - 1] * 3 + 1;
        }

        for (int k = incrementSequence.length - 1; k >= 0; k--) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j >= incrementSequence[k] && less(a[j], a[j - incrementSequence[k]]); j -= incrementSequence[k]) {
                    exch(a, j, j - incrementSequence[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 2, 1};
        sort(a);
        StdOut.print(isSorted(a));
    }

}

