package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_33_One {

    public static void main(String[] args) {
        // Using doubly-linked list
        Deque<String> dq = new Deque<>();
        dq.pushLeft("One");
        dq.pushLeft("Two");
        dq.pushRight("Three");
        dq.pushRight("Four");
        for (String item : dq) {
            StdOut.println(item);
        }

        StdOut.println();
        StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
    }
}
