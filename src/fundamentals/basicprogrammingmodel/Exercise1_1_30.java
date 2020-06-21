package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_30 {

    public static int gcd(int p, int q) {
        while (q != 0) {
            int tmp = p % q;
            p = q;
            q = tmp;
        }
        return p;
    }

    public static void main(String[] args) {
        StdOut.print("Input N-by-N boolean array: ");
        int N = StdIn.readInt();
        if (N <= 0) throw new IllegalArgumentException("N should be positive!");

        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) continue;
                if (gcd(i, j) == 1) {
                    a[i][j] = true;
                    StdOut.printf("pair of i and j is (%d, %d)\n", i, j);
                }
            }
        }
    }
}
