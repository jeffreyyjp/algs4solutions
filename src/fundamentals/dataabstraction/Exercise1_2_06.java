package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_06 {

    public static boolean areRatations(String s, String t) {
        return s.length() == t.length() && ((s + s).indexOf(t) != -1);
    }

    public static void main(String[] args) {
        StdOut.print("Input the first string: ");
        String s = StdIn.readString();
        StdOut.print("Input the second string: ");
        String t = StdIn.readString();
        StdOut.printf("%s and %s are circular rotation with each other ? %s\n", s, t, areRatations(s, t));
    }
}
