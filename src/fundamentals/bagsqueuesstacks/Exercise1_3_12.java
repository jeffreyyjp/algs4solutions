package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_12 {

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> tmp = new Stack<>();
        Stack<String> result = new Stack<>();
        for (String item : stack)
            tmp.push(item);

        for (String item : tmp) {
            result.push(item);
        }

        return result;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        Stack<String> copy = copy(stack);
        for (String item : copy) {
            StdOut.print(item + " ");
        }
    }
}
