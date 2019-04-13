package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_07 {

    public static void main(String[] args) {
        String[] s = {"I", "Love", "You"};
        Stack<String> stack = new Stack<>();
        for (String item : s)
            stack.push(item);
        StdOut.println("Size of stack : " + stack.size());

        StdOut.println(stack.peek());
        StdOut.println("After peek, size of stack : " + stack.size());

    }
}
