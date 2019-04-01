package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_24 {

    /**
     * Compute the greatest common divisor of p and q.
     *
     * @param p the first number.
     * @param q the second number.
     * @return greatest common divisor of p and q.
     */
    public static int gcd(int p, int q) {
        StdOut.printf("p = %d, q = %d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        StdOut.printf("Input your first positive integer number: ");
        int first_num = StdIn.readInt();
        StdOut.printf("Input your second positive integer number: ");
        int second_num = StdIn.readInt();
        if (first_num <= 0 || second_num <= 0)
            throw new IllegalArgumentException("first and second number should both be positive!");
        StdOut.printf("gcd of %d and %d is %d\n", first_num, second_num, gcd(first_num, second_num));
    }
}
