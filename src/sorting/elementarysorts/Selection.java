package sorting.elementarysorts;

public class Selection extends Example {

    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // Exchange a[i] with smallest entry in a(i+1...n).
            int min = i;        // index of minimal entry.
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
