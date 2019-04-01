package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_26 {

    public static void sort(int a, int b, int c) {
        StdOut.printf("Before sorted: a = %d, b = %d, c = %d.\n", a, b, c);
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        StdOut.printf("After sorted: a = %d, b = %d, c = %d.\n", a, b, c);
    }

    public static void main(String[] args) {
        StdOut.print("Input three integer number: ");
        int[] nums = StdIn.readAllInts();
        if (nums.length != 3)
            throw new IllegalArgumentException("num of arguments should be 3!");
        sort(nums[0], nums[1], nums[2]);
    }
}
