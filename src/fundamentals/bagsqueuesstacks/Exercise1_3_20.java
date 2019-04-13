package fundamentals.bagsqueuesstacks;

public class Exercise1_3_20<Item> {

    private Node first;
    private int N;

    public boolean delete(int k) {
        if (k < 0) throw new IllegalArgumentException("k can't be negative!");

        if (k >= N) return false;
        if (k == 0) first = first.next;
        else {
            Node current = first;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        return true;
    }
}
