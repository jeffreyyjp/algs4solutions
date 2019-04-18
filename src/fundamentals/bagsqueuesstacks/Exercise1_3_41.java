package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_41 {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("I");
        q.enqueue("Love");
        q.enqueue("You");
        Queue<String> r = new Queue<>(q);
        r.dequeue();

        for (String item : q) {
            StdOut.println(item);
        }
        StdOut.println();

        for (String item : r) {
            StdOut.println(item);
        }
    }
}
