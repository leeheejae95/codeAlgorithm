package edu.code.one_st;

public class Code4 {

    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int cnt = 1;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if(cnt > 0) {
                    answer += cnt;
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Code4 T = new Code4();
        System.out.println(T.solution("acccdeee"));
        System.out.println(T.solution("abc"));
        System.out.println(T.solution("aaabbbc"));
        System.out.println(T.solution("abbbc"));
        System.out.println(T.solution("ahhhhz"));
        System.out.println(T.solution("acccdeee"));

    }
}
