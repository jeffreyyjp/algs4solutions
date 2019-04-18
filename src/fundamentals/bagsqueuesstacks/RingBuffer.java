package fundamentals.bagsqueuesstacks;

public class RingBuffer<Item> {

    private Item[] a;
    private int readPointer;
    private int n;

    public RingBuffer(int capacity) {
        a = (Item[]) new Object[capacity];
        readPointer = 0;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public int size() {
        return n;
    }

    public Item consume() {
        if (isEmpty()) throw new IllegalArgumentException("Buffer is empty");
        Item item = a[readPointer];
        readPointer = (readPointer + 1) % a.length;
        n--;
        return item;
    }

    public void produce(Item item) {
        if (isFull()) throw new IllegalArgumentException("Buffer is full");
        int writePointer = (readPointer + n) % a.length;
        a[writePointer] = item;
        n++;
    }
}
