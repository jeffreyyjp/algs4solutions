package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_16 {

    public static void main(String[] args) {
        // Using Rational class.
        Rational a = new Rational(-1, 2);
        Rational b = new Rational(1, 3);
        StdOut.println(a.plus(b));
        StdOut.println(a.minus(b));
        StdOut.println(a.times(b));
        StdOut.println(a.divides(b));
        StdOut.println(a.equals(b));
    }
}
