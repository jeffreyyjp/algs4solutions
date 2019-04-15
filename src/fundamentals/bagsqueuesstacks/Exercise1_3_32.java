package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_32 {

    public static void main(String[] args) {
        Steque<String> sq = new Steque<>();
        sq.push("I");
        sq.push("Love");
        sq.push("You");

        for (String item : sq) {
            StdOut.println(item);
        }
        StdOut.println();

        sq.pop();
        sq.enqueue("You");
        for (String item : sq) {
            StdOut.println(item);
        }
        StdOut.println();
    }
}
