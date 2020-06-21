package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_15 {

    public static String[] doubleQueueToStack(String[] input, int k) {
        String[] result = new String[k + 1];
        Queue<String> queue1 = new Queue<>();
        Queue<String> queue2 = new Queue<>();
        Queue<String> tmp;
        for (String s : input) {
            queue1.enqueue(s);
        }
        for (int i = 0; i <= k; i++) {
            while (queue1.size() != 1) {
                queue2.enqueue(queue1.dequeue());
            }
            result[i] = queue1.dequeue();
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input = "I love you too".split("\\s");
        StdOut.print("Input k to print kth from the last string: ");
        int k = StdIn.readInt();
        if (input.length <= k) throw new IllegalArgumentException("k should less than length of input!");

        String[] result = doubleQueueToStack(input, k);
        for (String s : result)
            StdOut.print(s + " ");
    }
}
