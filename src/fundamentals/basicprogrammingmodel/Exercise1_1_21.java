package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_21 {

    public static void main(String[] args) {
        StdOut.println("Input names and two integers each line:");
        String[] input = StdIn.readAllLines();
        double result;
        StdOut.printf("\n%8s %7s %7s %7s\n", "Names", "Number1", "Number2", "Divided");
        for (int i = 0; i < input.length; i += 3) {
            if (i % 3 == 0)
                StdOut.println();
            result = Double.parseDouble(input[i + 1]) / Double.parseDouble(input[i + 2]);
            StdOut.printf("\n%8s %7s %7s %7.3f\n", input[i], input[i + 1], input[i + 2], result);
        }
    }
}
