package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_24 {

    public static void removeAfter(Node<String> node) {
        if (node == null || node.next == null)
            return;

        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();
        first.item = "I";
        first.next = second;
        second.item = "Love";
        second.next = third;
        third.item = "You";
        third.next = null;

        removeAfter(second);

        while (first != null) {
            StdOut.println(first.item);
            first = first.next;
        }
    }
}
