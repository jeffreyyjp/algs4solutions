package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_26 {


    public static Node<String> remove(Node<String> first, String key) {
        if (key == null) return first;
        while (first != null && first.item.equals(key))
            first = first.next;

        if (first != null) {
            Node<String> current = first;
            while (current.next != null) {
                if (current.next.item.equals(key))
                    current.next = current.next.next;
                else current = current.next;
            }
        }

        return first;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();
        Node<String> fourth = new Node<>();
        first.item = "Hello";
        first.next = second;
        second.item = "World";
        second.next = third;
        third.item = "World";
        third.next = fourth;
        fourth.item = "Too";
        fourth.next = null;

        first = remove(first, "World");
        while (first != null) {
            StdOut.println(first.item);
            first = first.next;
        }
    }
}
