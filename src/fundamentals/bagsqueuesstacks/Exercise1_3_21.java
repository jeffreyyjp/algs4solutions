package fundamentals.bagsqueuesstacks;


import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_21 {

    public static boolean find(Node<String> first, String key) {
        if (key == null) return false;
        Node<String> current = first;
        while (current != null) {
            if (current.item.equals(key))
                return true;
            current = current.next;
        }

        return false;
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

        StdOut.println(find(first, "Love"));
        StdOut.println(find(first, "you"));
    }
}
