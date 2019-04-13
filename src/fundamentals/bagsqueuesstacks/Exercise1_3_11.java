package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_11 {

    public static double computePostfix(String[] input) {
        Stack<Double> vals = new Stack<>();
        for (String s : input) {
            double val2 = 0;
            double val1 = 0;
            if (s.equals("+")) {
                val2 = vals.pop();
                val1 = vals.pop();
                vals.push(val1 + val2);
            } else if (s.equals("-")) {
                val2 = vals.pop();
                val1 = vals.pop();
                vals.push(val1 - val2);
            } else if (s.equals("*")) {
                val2 = vals.pop();
                val1 = vals.pop();
                vals.push(val1 * val2);
            } else if (s.equals("/")) {
                val2 = vals.pop();
                val1 = vals.pop();
                vals.push(val1 / val2);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }

        return vals.pop();
    }

    public static void main(String[] args) {
        String[] input = "1 2 3 + 4 * + 5 -".split("\\s");
        StdOut.println(computePostfix(input));
    }
}
