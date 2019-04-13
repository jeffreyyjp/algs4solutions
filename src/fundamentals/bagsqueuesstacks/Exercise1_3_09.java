package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_09 {

    public static void main(String[] args) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] inputs = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )".split("\\s");
        for (String input : inputs) {
            if (input.equals("(")) ;
            else if (input.equals("+")) operators.push(input);
            else if (input.equals("-")) operators.push(input);
            else if (input.equals("*")) operators.push(input);
            else if (input.equals("/")) operators.push(input);
            else if (input.equals(")")) {
                String operator = operators.pop();
                String val2 = operands.pop();
                String val1 = operands.pop();
                operands.push("( " + val1 + " " + operator + " " + val2 + " )");
            } else {
                operands.push(input);
            }
        }

        StdOut.println(operands.pop());
    }
}
