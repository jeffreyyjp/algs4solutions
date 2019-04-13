package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_05 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        StdOut.print("Input N: ");
        int N = StdIn.readInt();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}

// Output:
/*
Prints the binary representation of N (110010 when N is 50).
 */
