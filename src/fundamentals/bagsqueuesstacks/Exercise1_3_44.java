package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_44 {

    public static void main(String[] args) {
        Buffer bf = new Buffer();
        bf.insert('a');
        bf.insert('b');
        bf.insert('c');
        bf.insert('d');
        bf.insert('e');
        bf.left(2);
        bf.delete();

        StdOut.println(bf);
    }
}
