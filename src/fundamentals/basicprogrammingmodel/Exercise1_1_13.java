package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_13 {

    /**
     * Output the two-dimensional array.
     *
     * @param arr a two-dimensional int array.
     */
    public static void outputArr(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                StdOut.printf("%d ", arr[i][j]);
            StdOut.println();
        }
    }

    /**
     * Randomly set each element to between 0 and 10.
     *
     * @param arr a two-dimensional int array.
     */
    public static void randomArr(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = StdRandom.uniform(0, 10);
    }

    /**
     * Row and col are equal, don't need to create new array when row and col
     * changed.
     *
     * @param arr a two-dimensional int array.
     */
    public static void equalRowAndColChanged(int[][] arr) {
        int rows = arr.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    /**
     * Reverse a two-dimensional int array if row differs from cols.
     *
     * @param arr a two-dimensional int array.
     * @return a new reversed array(need to create new array).
     */
    public static int[][] rowAndColChanged(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] newArr = new int[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                newArr[i][j] = arr[j][i];

        return newArr;
    }

    public static void main(String[] args) {
        StdOut.print("Please input rows of a two-dimensional array: ");
        int M = StdIn.readInt();
        StdOut.print("Please input colums of a two-dimensional array: ");
        int N = StdIn.readInt();
        if (0 >= M || 0 >= N)
            throw new IllegalArgumentException(
                    "row and column should be positive!");

        int[][] arr = new int[M][N];
        randomArr(arr);
        StdOut.println("Before rows and columns changes.");
        outputArr(arr);

        StdOut.println("\nAfter rows and columns changes.");
        if (M == N) {
            equalRowAndColChanged(arr);
            outputArr(arr);
        } else {
            int[][] newArr = rowAndColChanged(arr);
            outputArr(newArr);
        }
    }
}
