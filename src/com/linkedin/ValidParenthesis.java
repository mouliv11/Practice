package com.linkedin;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char c1;
            switch(c) {
                case ')':
                    c1 = stack.pop();
                    if (c1 == '[' || c1 == '{')
                        return false;
                    break;
                case '}':
                    c1 = stack.pop();
                    if (c1 == '(' || c1 == '[')
                        return false;
                    break;
                case ']':
                    c1 = stack.pop();
                    if (c1 == '(' || c1 == '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
