/* Java implementation to convert
infix expression to postfix*/
// Note that here we use Stack class for Stack operations

import java.util.Stack;

public class Infix2Postfix
{
    private static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<exp.length(); i++) {
            Character c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.empty() && prec(c) <= prec(stack.peek()))
                    result.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid expression";
            result.append(stack.pop());
        }
        return result.toString();
    }
}
