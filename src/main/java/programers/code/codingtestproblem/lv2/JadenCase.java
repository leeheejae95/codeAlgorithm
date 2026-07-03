package programers.code.codingtestproblem.lv2;

public class JadenCase {

    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for(char x : s.toCharArray()) { // 3people unFollowed me
            if(x == ' ') {
                answer += x;
                flag = true;
            } else {
                if(flag) {
                    answer += Character.toUpperCase(x); // u -> U m -> M
                    flag = false;
                } else {
                    answer += Character.toLowerCase(x); // 3people nFollowed e
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase T = new JadenCase();
        System.out.println(T.solution("3people unFollowed me"));
        System.out.println(T.solution("for the last week"));
    }
}
