package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_37 {

    public static void josephusQueue(int N, int M) {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }
        StdOut.println("Order of being eliminated is: ");
        while (!q.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                q.enqueue(q.dequeue());
            }
            StdOut.print(q.dequeue() + " ");
        }
    }

    public static void main(String[] args) {
        StdOut.print("Input N for total people: ");
        int N = StdIn.readInt();
        StdOut.print("Input M for Mth person to be eliminated: ");
        int M = StdIn.readInt();
        if (M >= N || N <= 0 || M < 0) {
            throw new IllegalArgumentException("Wrong arguments!");
        }

        josephusQueue(N, M);
    }
}
