package fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_1_01 {
	
	public static void main(String[] args) {
		int val1 = (0 + 15) / 2;
		double val2 = 2.0e-6 * 100000000.1;
		boolean val3 = true && false || true && true;
		StdOut.println(val1);
		StdOut.println(val2);
		StdOut.println(val3);
	}
}

//Output:
/*
7
200.0000002
true
*/