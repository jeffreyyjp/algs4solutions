package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_16 {

    public static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }
}

// Output:
/*
 * 131246
 */