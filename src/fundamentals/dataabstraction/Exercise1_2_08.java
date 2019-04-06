package fundamentals.dataabstraction;

public class Exercise1_2_08 {

    /**
     * Copy references to swap arrays
     *
     * @param a
     * @param b
     */
    public static void swap(int[] a, int[] b) {
        int[] t = a;
        a = b;
        b = t;
    }
}
