package programers.code.codingtestproblem.lv2.practice;

public class JadenCasePractice {

    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for(char c : s.toCharArray()) {
            if(c==' ') {
                answer += c;
                flag = true;
            } else {
                if(flag) {
                    answer += Character.toUpperCase(c);
                    flag = false;
                } else {
                    answer += Character.toLowerCase(c);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCasePractice T = new JadenCasePractice();
        System.out.println(T.solution("3people unFollowed me"));
        System.out.println(T.solution("for the last week"));
    }
}