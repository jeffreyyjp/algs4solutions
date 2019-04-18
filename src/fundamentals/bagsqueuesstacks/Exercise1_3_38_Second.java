package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_38_Second {

    // Using GeneralizedListQueue
    public static void main(String[] args) {
        GeneralizedListQueue<String> q = new GeneralizedListQueue<>();
        q.insert("I");
        q.insert("Love");
        q.insert("You");

        StdOut.println(q.delete(1));
    }
}
