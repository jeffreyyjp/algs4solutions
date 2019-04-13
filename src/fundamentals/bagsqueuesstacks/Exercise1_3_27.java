package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_27 {

    public static int max(Node<Integer> first) {
        if (first == null) return 0;
        Node<Integer> current = first;
        int max = 0;
        while (current != null) {
            if (current.item > max)
                max = current.item;
            current = current.next;
        }

        return max;
    }

    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        Node<Integer> second = new Node<>();
        Node<Integer> third = new Node<>();
        first.item = 3;
        first.next = second;
        second.item = 5;
        second.next = third;
        third.item = 2;
        third.next = null;
        StdOut.println(max(first));
    }
}
