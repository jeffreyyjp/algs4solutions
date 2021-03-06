package strings.stringsorts;

public class MSD {
    private static int R = 256; // radix
    private static final int M = 15; // cutoff for small subarrays
    private static String[] aux; // auxiliary array for distribution

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // Sort from a[lo] to a[hi], starting at the dth character.
        if (hi <= lo + M) {
            insertion(a, lo, hi, d);
        }

        int[] count = new int[R + 2]; // Compute frequency counts.
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) { // Transform counts to indices.
            count[r + 1] += count[r];
        }

        for (int i = lo; i <= hi; i++) { // Distribute.
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) { // Copy back.
            a[i] = aux[i - lo];
        }

        // Recursively sort for each character value.
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    private static void exch(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
}
