package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_38_First {

    public static void main(String[] args) {
        // Using GeneralizedArrayQueue
        GeneralizedArrayedQueue<String> q = new GeneralizedArrayedQueue<>();
        q.insert("I");
        q.insert("Love");
        q.insert("You");

        StdOut.println(q.delete(1));
    }
}
