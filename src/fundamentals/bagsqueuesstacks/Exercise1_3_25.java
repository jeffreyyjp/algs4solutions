package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_25 {

    public static void insertAfter(Node<String> current, Node<String> inserted) {
        if (current == null || inserted == null)
            return;

        inserted.next = current.next;
        current.next = inserted;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> inserted = new Node<>();
        first.item = "I";
        first.next = second;
        second.item = "You";
        second.next = null;
        inserted.item = "Love";
        inserted.next = null;
        insertAfter(first, inserted);

        while (first != null) {
            StdOut.println(first.item);
            first = first.next;
        }
    }
}
