package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_33_Second {

    public static void main(String[] args) {
        // Using resizing array.
        ResizingArrayDeque<String> dq = new ResizingArrayDeque<>();
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
