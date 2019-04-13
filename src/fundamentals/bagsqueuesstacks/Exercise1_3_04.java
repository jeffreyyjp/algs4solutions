package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_04 {

    public static boolean checkBalanced(String s) {
        String leftParentheses = "[({";
        String rightParentheses = "])}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (leftParentheses.indexOf(s.charAt(i)) != -1) {
                stack.push(s.charAt(i));
                continue;
            }
            int index = rightParentheses.indexOf(s.charAt(i));
            if (index != -1) {
                if (leftParentheses.indexOf(stack.pop()) != index)
                    return false;
            } else
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println("Input string to check parentheses are properly balanced: ");
        String input = StdIn.readString();

        StdOut.printf("%s parentheses are properly balanced ? %s\n", input, checkBalanced(input));
    }
}
