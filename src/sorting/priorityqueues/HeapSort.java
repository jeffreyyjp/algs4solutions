package sorting.priorityqueues;

public class HeapSort {
    
    private static void sink(Comparable[] pq, int k, int n)
    {
        while (2 * k <= n)
        {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void exch(Comparable[] pq, int i, int j)
    {
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void sort(Comparable[] pq)
    {
        int n = pq.length;
        for (int k = n / 2; k >= 1; k--)
            sink(pq, k, n);
        
        while (n > 1)
        {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }
}
