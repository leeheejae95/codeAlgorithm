package org.example.datastructure.unzip;

import java.util.*;

public class UnzipPractice {
    public String solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x == ')') {
                String tmp = "";
                while(!stack.isEmpty()) {
                    String c = stack.pop();
                    if(c.equals("(")) {
                        String num = "";
                        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) num = stack.pop() + num;
                        String res = "";
                        int cnt = 0;
                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);
                        for(int i=0; i<cnt; i++) res += tmp;
                        stack.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else {
                stack.push(String.valueOf(x));
            }
        }
        for(String x : stack) {
            answer += x;
        }

        return answer;
    }

    public static void main(String[] args){
        UnzipPractice T = new UnzipPractice();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
