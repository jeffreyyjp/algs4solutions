package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_06 {

    public static void reverseQueue(Queue<String> q) {
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }

    public static void main(String[] args) {
        String[] s = {"I", "Love", "You"};
        Queue<String> q = new Queue<>();
        for (String item : s)
            q.enqueue(item);

        reverseQueue(q);
        for (String item : q)
            StdOut.println(item);
    }
}

// Output:
/*
reverse items in queue.
 */
