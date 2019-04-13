package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

    public static void main(String[] args) {
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

//        String[] inputs = StdIn.readAllStrings();
        String[] inputs = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )".split("\\s");
        for (String input : inputs) {
            if (input.equals("(")) ;
            else if (input.equals("+")) operators.push(input);
            else if (input.equals("-")) operators.push(input);
            else if (input.equals("*")) operators.push(input);
            else if (input.equals("/")) operators.push(input);
            else if (input.equals(")")) {
                String operator = operators.pop();
                double val2 = operands.pop();
                double val1 = operands.pop();
                if (operator.equals("+")) operands.push(val1 + val2);
                else if (operator.equals("-")) operands.push(val1 - val2);
                else if (operator.equals("*")) operands.push(val1 * val2);
                else if (operator.equals("/")) operands.push(val1 / val2);
            } else {
                operands.push(Double.parseDouble(input));
            }
        }

        StdOut.println(operands.pop());
    }
}
