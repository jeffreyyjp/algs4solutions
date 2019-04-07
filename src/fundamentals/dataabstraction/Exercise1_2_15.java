package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_15 {

    public static void main(String[] args) {
        StdOut.print("Input file name: ");
        String name = StdIn.readString();
        // Using TestIn.
        int[] input = TestIn.readInts(name);

        for (int item : input)
            StdOut.println(item);
    }
}
