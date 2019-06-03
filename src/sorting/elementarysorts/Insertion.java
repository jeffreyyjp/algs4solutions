package sorting.elementarysorts;

public class Insertion extends Example {

    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]...
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
