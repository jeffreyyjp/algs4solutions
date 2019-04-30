package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_45 {

    public static boolean isStackUnderflow(String[] inputvalues) {
        int itemCount = 0;

        for (String item : inputvalues) {
            if (item.equals("-")) {
                itemCount--;
            } else {
                itemCount++;
            }

            if (itemCount < 0) {
                return true;
            }
        }

        return false;
    }

    public static boolean canPermutationBeGenerated(String[] inputValues) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        for (String item : inputValues) {
            int value = Integer.parseInt(item);
            if (stack.isEmpty() || value > stack.peek()) {
                while (current < value) {
                    stack.push(current);
                    current++;
                }
                current++;
            } else if (value == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input1Values = "0 1 2 - - -";
        String[] input1 = input1Values.split("\\s");
        StdOut.println("input1 is underflow?: " + isStackUnderflow(input1));

        String input2Values = "0 1 2 - - - 3 4 5 - - 6 - - -";
        String[] input2 = input2Values.split("\\s");
        StdOut.println("input1 is underflow?: " + isStackUnderflow(input2));

        String input3Values = "4 3 2 1 0 9 8 7 6 5";
        String[] input3 = input3Values.split("\\s");
        StdOut.println("Can permutation be generated ?: " + canPermutationBeGenerated(input3));

        String input4Values = "4 6 8 7 5 3 2 9 0 1";
        String[] input4 = input4Values.split("\\s");
        StdOut.println("Can permutation be generated ?: " + canPermutationBeGenerated(input4));
    }
}
