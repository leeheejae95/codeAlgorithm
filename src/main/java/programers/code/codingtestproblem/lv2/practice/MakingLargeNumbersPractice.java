package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class MakingLargeNumbersPractice {

    public String solution(String number, int k) {
//        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : number.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peek()<c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MakingLargeNumbersPractice T = new MakingLargeNumbersPractice();
        System.out.println(T.solution("1924",2));
        System.out.println(T.solution("1231234",3));
        System.out.println(T.solution("4177252841",4));
    }
}
