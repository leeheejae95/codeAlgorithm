package programers.code.codingtestproblem.lv2;

import java.util.*;

public class PairAndRemove {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        PairAndRemove T = new PairAndRemove();
        System.out.println(T.solution("baabaa"));
        System.out.println(T.solution("cdcd"));
    }
}
