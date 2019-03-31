package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_05 {

    public static boolean isZeroToOne(double num) {
        return num >= 0 && num < 1;
    }

    public static void main(String[] args) {
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        boolean result = isZeroToOne(x) && isZeroToOne(y);
        StdOut.printf("x and y are both strictly between 0 and 1? : %s",
                result);
    }

}
