package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_42 {

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("I");
        s.push("Love");
        s.push("You");

        Stack<String> t = new Stack<>(s);
        t.pop();
        for (String item : t) {
            StdOut.println(item);
        }
        StdOut.println();

        for (String item : s) {
            StdOut.println(item);
        }
    }
}
