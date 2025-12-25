package edu.code.fifth_st;

public class CorrectParentheses {
    public static String solution(String str) {
        return  transForm(str);
    }

    public static String transForm(String str) {
        if (str.isEmpty()) return "";

        int balance = isBalance(str);
        String u = str.substring(0, balance);
        String v =  str.substring(balance);
        boolean correct = isCorrect(u);
        if(correct) {
            return u + transForm(v);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('(').append(transForm(v)).append(')');
        for(int i=1; i<u.length()-1; i++) {
            sb.append(u.charAt(i)=='(' ? ')' : '(');
        }

        return sb.toString();
    }

    public static int isBalance(String str) {
        int bal = 0;
        for(int i=0; i<str.length(); i++) {
            bal += (str.charAt(i) == '(' ? 1 : -1);
            // 0일 경우 균형있는 괄호 이므로 문자열 길이를 반황해야됨
            // 인덱스는 0부터 시작하니깐....
            if(bal == 0) return i+1;
        }
        return str.length();
    }
    public static boolean isCorrect(String str) {
        int bal = 0;
        for(int i=0; i<str.length(); i++) {
            bal += (str.charAt(i) == '(' ? 1 : -1);
            if(bal < 0) return false; // 닫는게 먼저 나오면 false
        }

        return bal==0;
    }

    public static void main(String[] args) {
        System.out.println("정답 = (((()))) / 현재 풀이 값 = " + solution(")()()()("));
//        System.out.println("정답 = ()()() / 현재 풀이 값 = " + solution("))()()"));
//        System.out.println("정답 = ((((()())))) / 현재 풀이 값 = " + solution(")()()()(())("));
    }
}
