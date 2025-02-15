//VALID PARENTHESES (leetcode)
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

package org.anubhav;
import java.util.Stack;

public class ValidParantheis {
        public static boolean isValid(String s) {
            if (s.length() < 2) return false;

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c); //push to stack if found open brackets
                } else {
                    // If it's a closing bracket pop from stack and match with corresponding closing brackets
                    if (stack.isEmpty() || !isMatching(stack.pop(), c)) return false;
                }
            }
            return stack.isEmpty();
        }

        private static boolean isMatching(char open, char close) {
            return (open == '(' && close == ')') ||
                    (open == '[' && close == ']') ||
                    (open == '{' && close == '}');
        }

    public static void main(String[] args) {
        String s = "{{}}[()]";
        System.out.println(isValid(s));
    }
}
