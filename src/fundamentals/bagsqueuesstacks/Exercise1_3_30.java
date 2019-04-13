package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_30 {

    public static Node reverse(Node first) {
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }

    public static Node recursiveReverse(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = recursiveReverse(second);
        second.next = first;
        first.next = null;

        return rest;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();
        Node<String> current;
        first.item = "I";
        first.next = second;
        second.item = "Love";
        second.next = third;
        third.item = "You";
        third.next = null;

        first = reverse(first);
        current = first;
        while (current != null) {
            StdOut.println(current.item);
            current = current.next;
        }
        StdOut.println();

        first = recursiveReverse(first);
        current = first;
        while (current != null) {
            StdOut.println(current.item);
            current = current.next;
        }
    }
}
