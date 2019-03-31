package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_03 {

    public static boolean isEqual(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] != arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StdOut.print("Please input three positive integers: ");
        int[] nums = StdIn.readAllInts();
        int N = nums.length;
        if (3 != N)
            throw new IllegalArgumentException("nums of parameter is wrong!");
        StdOut.printf("The three integers is equal? : %s\n", isEqual(nums));
    }
}
