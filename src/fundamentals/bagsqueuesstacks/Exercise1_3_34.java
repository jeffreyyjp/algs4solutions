package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_34 {

    public static void main(String[] args) {
        RandomBag<String> rb = new RandomBag<>();
        rb.add("I");
        rb.add("Love");
        rb.add("You");
        for (String item : rb) {
            StdOut.println(item);
        }
    }
}
