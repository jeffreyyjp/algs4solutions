package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class MoveToFront<Item> {

    private Node<Item> first;

    public MoveToFront() {
        first = null;
    }

    public void moveToFront(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        Node current = first;
        while (current.next != null) {
            if (current.next.item == first.item) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public Item pop() {
        if (first == null) throw new NoSuchElementException("List is empty");
        Item item = first.item;
        first = first.next;
        return item;
    }
}
