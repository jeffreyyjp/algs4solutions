package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_47 {

    public static void main(String[] args) {
        CircularQueue<String> first = new CircularQueue<>();
        first.enqueue("I");
        first.enqueue("Love");
        first.enqueue("You");

        CircularQueue<String> second = new CircularQueue<>();
        second.enqueue("13");
        second.enqueue("14");
        first.catenation(second);

        for (String item : first) {
            StdOut.println(item);
        }
    }
}
