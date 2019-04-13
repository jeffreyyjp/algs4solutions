package fundamentals.bagsqueuesstacks;

public class Exercise1_3_19<Item> {

    private Node first;

    public boolean removeLast() {
        if (first == null) return false;
        if (first.next == null) first = null;
        else {
            Node current = first;
            while (current.next.next != null)
                current = current.next;
            current.next = null;
        }

        return true;
    }

}
