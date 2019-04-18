package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_36 {

    public static void main(String[] args) {
        RandomQueue<String> rq = new RandomQueue<>();
        rq.enqueue("I");
        rq.enqueue("Love");
        rq.enqueue("You");

        for (String item : rq) {
            StdOut.println(item);
        }
    }
}
