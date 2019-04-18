package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class Exercise1_3_20<Item> {

    private Node<Item> first;
    private int n;

    public Item delete(int k) {
        if (n == 0) throw new NoSuchElementException("List is empty");
        if (k < 0 || k >= n) throw new IllegalArgumentException();
        Item item = first.item;
        if (k == 0) first = first.next;
        else {
            Node<Item> current = first;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            item = current.next.item;
            current.next = current.next.next;
        }

        return item;
    }
}
