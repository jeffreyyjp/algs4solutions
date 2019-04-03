package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_33 {

    // vector dot product
    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length)
            throw new IllegalArgumentException();

        int N = x.length;
        double result = 0;
        for (int i = 0; i < N; i++)
            result += x[i] * y[i];
        return result;
    }

    // matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b) {
        // a's cols should be equal with b's rows.
        if (a == null || b == null || a.length == 0 || b.length == 0 || a[0].length != b.length)
            throw new IllegalArgumentException();

        int aRow = a.length;
        int aCol = a[0].length;
        int bCol = b[0].length;
        double[][] result = new double[aRow][bCol];
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bCol; j++) {
                for (int k = 0; k < aCol; k++)
                    result[i][j] += a[i][k] * b[k][j];
            }
        }

        return result;
    }

    // transpose
    public static double[][] transpose(double[][] a) {
        // exchange rows and cols.
        if (a == null || a.length == 0)
            throw new IllegalArgumentException();

        int row = a.length;
        int col = a[0].length;
        double[][] result = new double[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++)
                result[i][j] = a[j][i];
        }

        return result;
    }

    // matrix-vector product
    public static double[] mult(double[][] a, double[] x) {
        // a's cols should be equal with x.
        if (a == null || a.length == 0 || x == null || x.length == 0 || a[0].length != x.length)
            throw new IllegalArgumentException();

        int len = a.length;
        double[] result = new double[len];
        for (int i = 0; i < len; i++)
            result[i] = dot(a[i], x);

        return result;
    }

    // vector-matrix product
    public static double[] mult(double[] y, double[][] a) {
        if (a == null || y == null || a.length != y.length)
            throw new IllegalArgumentException();

        int len = a[0].length;
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < a.length; j++)
                result[i] += y[j] * a[j][i];
        }

        return result;
    }

    public static void main(String[] args) {
        // dot test.
        StdOut.println("Dot for x and y.");
        double[] x = {2.0, 3.0, 4.0};
        double[] y = {3.0, 4.0, 5.0};
        StdOut.printf("Dot(x, y) = %f\n", dot(x, y));

        // matrix-matrix product test.
        StdOut.println("\nmatrix-matrix product for A and B.");
        double[][] A = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        double[][] B = {{1.0, 4.0}, {2.0, 5.0}, {3.0, 6.0}};
        double[][] result0 = mult(A, B);
        for (double[] items : result0) {
            for (double subItem : items)
                StdOut.printf("%f ", subItem);
            StdOut.println();
        }

        // transpose test
        StdOut.println("\ntranspose for A.");
        double[][] result1 = transpose(A);
        for (double[] items : result1) {
            for (double subItem : items)
                StdOut.printf("%f ", subItem);
            StdOut.println();
        }

        // matrix-vector product test
        StdOut.println("\nmatrix-vector product for A and x.");
        double[] result2 = mult(A, x);
        for (double item : result2)
            StdOut.printf("%f ", item);
        StdOut.println();

        // vector-matrix product test.
        StdOut.println("\nvector-matrix product for x and B.");
        double[] result3 = mult(y, B);
        for (double item : result3)
            StdOut.printf("%f ", item);
        StdOut.println();
    }
}
