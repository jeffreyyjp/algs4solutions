package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_40<Item> {

    public static void main(String[] args) {
        MoveToFront<Character> list = new MoveToFront<>();
        list.moveToFront('I');
        list.moveToFront('L');
        list.moveToFront('Y');
        list.moveToFront('I');

        StdOut.println(list.pop());
        StdOut.println(list.pop());
        StdOut.println(list.pop());
    }
}
