package programers.code.codingtestproblem.lv2;

import java.util.Stack;

public class ParenthesisRotation {

    public boolean isValid(String text) {
        Stack<Character> stack = new Stack<>();
        for(char c : text.toCharArray()) { // [](){}
            if(c=='[' || c=='(' || c=='{') {
                stack.push(c); // [
            } else {
                if(stack.isEmpty()) return false;
                char textPop = stack.pop(); // [
                if(c==']' && textPop != '[') return false;
                if(c==')' && textPop != '(') return false;
                if(c=='}' && textPop != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++) {
            String text = s.substring(i) + s.substring(0,i);
            if(isValid(text)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ParenthesisRotation T = new ParenthesisRotation();
        System.out.println(T.solution("[](){}"));
        System.out.println(T.solution("}]()[{"));
        System.out.println(T.solution("[)(]"));
        System.out.println(T.solution("}}}"));
    }
}
