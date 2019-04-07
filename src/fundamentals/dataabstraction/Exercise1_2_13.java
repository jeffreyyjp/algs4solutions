package fundamentals.dataabstraction;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_2_13 {

    public static void main(String[] args) {
        Transaction[] trans = new Transaction[4];
        trans[0] = new Transaction("Turing   6/17/1990  644.08");
        trans[1] = new Transaction("Tarjan   3/26/2002 4121.85");
        trans[2] = new Transaction("Knuth    6/14/1999  288.34");
        trans[3] = new Transaction("Dijkstra 8/22/2007 2678.40");

        for (Transaction item : trans)
            StdOut.println(item);
        StdOut.println();
    }
}
