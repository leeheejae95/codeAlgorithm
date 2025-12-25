package edu.code.third_st.problem;

import java.util.*;

public class Parentheses {
    public boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Parentheses T = new Parentheses();

        System.out.println(T.solution("(())()"));
        System.out.println(T.solution("(((("));
    }
}
