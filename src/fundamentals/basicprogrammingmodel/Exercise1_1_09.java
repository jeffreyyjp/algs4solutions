package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_09 {

    /**
     * Convert positive integer to binary string.
     *
     * @param N positive integer number.
     * @return binary representation string.
     */
    public static String integerToString(int N) {
        String s = "";
        if (0 > N)
            throw new IllegalArgumentException(
                    "N should be a positive integer!");
        for (int n = N; n > 0; n /= 2)
            s = n % 2 + s;
        return s;
    }

    public static void main(String[] args) {
        int num = StdIn.readInt();
        StdOut.printf("binary representation of %d is %s\n", num,
                integerToString(num));
    }
}
