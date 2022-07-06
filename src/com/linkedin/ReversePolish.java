package com.linkedin;

import java.util.Stack;

public class ReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (!stack.isEmpty()) {
                    int oper1 = stack.pop();
                    int oper2 = stack.pop();
                    switch (tokens[i]) {
                        case "+":
                            stack.push(oper1 + oper2);
                            break;
                        case "-":
                            stack.push(oper2 - oper1);
                            break;
                        case "*":
                            stack.push(oper1 * oper2);
                            break;
                        case "/":
                            stack.push(oper2 / oper1);
                            break;
                    }
                } else
                    throw new IllegalArgumentException("Invalid expression");

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolish r = new ReversePolish();
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(r.evalRPN(tokens));
    }
}