package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_31 {

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insertEnd("Hello");
        list.insertEnd("World");
        list.insertBegin("Too");

        for (String item : list) {
            StdOut.println(item);
        }
        StdOut.println();

        list.remove("Hello");
        list.removeBegin();
        for (String item : list) {
            StdOut.println(item);
        }
    }
}
