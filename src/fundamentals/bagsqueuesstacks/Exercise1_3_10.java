package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_10 {

    public static String[] infixToPrefix(String[] input) {
        Stack<String> expressions = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i].equals(")")) operators.push(input[i]);
            else if (input[i].equals("+") || input[i].equals("-")) {
                while (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/")))
                    expressions.push(operators.pop());
                operators.push(input[i]);
            } else if (input[i].equals("*") || input[i].equals("/"))
                operators.push(input[i]);
            else if (input[i].equals("(")) {
                while (!operators.peek().equals(")"))
                    expressions.push(operators.pop());
                operators.pop();
            } else {
                expressions.push(input[i]);
            }
        }

        while (!operators.isEmpty())
            expressions.push(operators.pop());
        String[] result = new String[expressions.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = expressions.pop();
        return result;
    }

    public static String[] infixToPostfix(String[] input) {
        Stack<String> expressions = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String s : input) {
            if (s.equals("(")) operators.push(s);
            else if (s.equals("+") || s.equals("-")) {
                while (!operators.isEmpty() && (operators.peek().equals("+") || operators.peek().equals("-")))
                    expressions.push(operators.pop());
                operators.push(s);
            } else if (s.equals("*") || s.equals("/")) {
                while (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/")))
                    expressions.push(operators.pop());
                operators.push(s);
            } else if (s.equals(")")) {
                while (!operators.peek().equals("("))
                    expressions.push(operators.pop());
                operators.pop();
            } else {
                expressions.push(s);
            }
        }

        while (!operators.isEmpty())
            expressions.push(operators.pop());
        String[] result = new String[expressions.size()];
        for (int i = result.length - 1; i >= 0; i--)
            result[i] = expressions.pop();
        return result;
    }

    public static void main(String[] args) {
        String[] inputs = "1 + ( ( 2 + 3 ) * 4 ) - 5".split("\\s");
        String[] toPrefix = infixToPrefix(inputs);
        for (String item : toPrefix)
            StdOut.print(item + " ");
        StdOut.println();

        String[] toPostfix = infixToPostfix(inputs);
        for (String item : toPostfix)
            StdOut.print(item + " ");
    }
}
