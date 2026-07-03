package programers.code.codingtestproblem.lv2;

import java.util.Stack;

public class CorrectParentheses {

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else { // )
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        CorrectParentheses T = new CorrectParentheses();
        System.out.println(T.solution("()()"));
        System.out.println(T.solution("(())()"));
        System.out.println(T.solution(")()("));
        System.out.println(T.solution("(()("));
    }
}
