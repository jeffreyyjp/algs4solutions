package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_11 {

    public static void main(String[] args) {
        StdOut.print("Input month number: ");
        int m = StdIn.readInt();
        StdOut.print("Input day number: ");
        int d = StdIn.readInt();
        StdOut.print("Input year number: ");
        int y = StdIn.readInt();

        SmartDate date = new SmartDate(m, d, y);
        StdOut.println(date);
    }
}
