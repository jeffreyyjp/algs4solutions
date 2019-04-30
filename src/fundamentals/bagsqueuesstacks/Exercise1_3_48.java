package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_48 {

    public static void main(String[] args) {
        DoubleStackedDeque<String> dsd = new DoubleStackedDeque<>();
        dsd.pushLeft("I");
        dsd.pushLeft("Love");
        dsd.pushRight("You");

        for (String item : dsd) {
            StdOut.println(item);
        }
    }
}
