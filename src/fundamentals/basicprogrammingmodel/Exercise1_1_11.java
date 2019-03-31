package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_11 {

    /**
     * Randomly set each elements to true or false.
     *
     * @param arr a two-dimensional boolean array.
     */
    public static void randomArr(boolean[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = StdRandom.bernoulli();
    }

    public static void main(String[] args) {
        StdOut.print("Please input count of rows: ");
        int rows = StdIn.readInt();
        StdOut.print("Please input count of columns: ");
        int cols = StdIn.readInt();
        if (rows <= 0 || cols <= 0)
            throw new IllegalArgumentException(
                    "row and column should be positive!");

        boolean[][] twoBolleanArr = new boolean[rows][cols];
        randomArr(twoBolleanArr);
        StdOut.printf("rows = %d, columns = %d\n", rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (twoBolleanArr[i][j])
                    StdOut.print("*");
                else
                    StdOut.print(" ");
            }
            StdOut.println();
        }
    }
}
