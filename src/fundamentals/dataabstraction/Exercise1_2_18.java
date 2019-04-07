package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_18 {

    public static void main(String[] args) {
        StdOut.print("Input T for total added numbers: ");
        int T = StdIn.readInt();
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++)
            a.addDataValue(StdRandom.uniform());
        StdOut.println(a);
    }
}
