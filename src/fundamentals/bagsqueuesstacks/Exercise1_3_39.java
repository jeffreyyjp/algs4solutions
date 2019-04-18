package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_39 {

    public static void main(String[] args) {
        RingBuffer<String> rb = new RingBuffer<>(3);
        rb.produce("I");
        rb.produce("Love");
        rb.produce("You");

        StdOut.println(rb.consume());
        StdOut.println(rb.consume());
        StdOut.println(rb.consume());
//        StdOut.println(rb.consume()); // buffer is empty
    }
}
